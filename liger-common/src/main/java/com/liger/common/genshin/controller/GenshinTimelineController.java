package com.liger.common.genshin.controller;

import com.liger.common.common.model.timeline.TlData;
import com.liger.common.common.model.timeline.TlMedia;
import com.liger.common.common.model.timeline.TlSlide;
import com.liger.common.common.model.timeline.TlText;
import com.liger.common.common.result.ResultResponseBody;
import com.liger.common.common.util.timeline.TimelineDataBuilder;
import com.liger.common.genshin.constant.EventType;
import com.liger.common.genshin.constant.PromotionWishType;
import com.liger.common.genshin.constant.ResourceUrl;
import com.liger.common.genshin.dto.GenshinBattlePassDto;
import com.liger.common.genshin.entity.GenshinEventEntity;
import com.liger.common.genshin.entity.GenshinPromotionWishEntity;
import com.liger.common.genshin.service.GenshinEventService;
import com.liger.common.genshin.service.GenshinVersionService;
import com.liger.common.genshin.service.GenshinWishService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@ResultResponseBody
@RequestMapping(value = "/genshin/timeline")
public class GenshinTimelineController {

    @Autowired
    private GenshinVersionService genshinVersionService;
    @Autowired
    private GenshinEventService genshinEventService;
    @Autowired
    private GenshinWishService genshinWishService;

    @RequestMapping(value = "/data.json")
    public TlData data() {
        TimelineDataBuilder builder = new TimelineDataBuilder();
        builder.setTitleText("原神活动时间线")
                .setDateField(Calendar.MINUTE)
                .setDatePattern("MM/dd HH:mm");

        genshinVersionService.queryVersionList().stream()
                .map(version -> builder.buildEra(version.getStartDate(), version.getEndDate(),
                        version.getVersion() + ' ' + version.getName()))
                .forEach(builder::addEra);

        genshinEventService.queryBattlePassList().stream()
                .map(battlePass -> {
                    TlSlide slide = builder.buildSlide(battlePass.getStartDate(), battlePass.getEndDate());
                    slide.setText(new TlText(battlePass.getName()));
                    TlMedia media = new TlMedia((battlePass.getImage()));
                    media.setLink(battlePass.getBbsArticleUrl());
                    slide.setMedia(media);
                    slide.setGroup("纪行");
                    slide.setUnique_id(getUniqueId(battlePass));
                    return slide;
                })
                .forEach(builder::addEvent);

        genshinWishService.queryPromotionWishList().stream()
                .map(wish -> {
                    TlSlide slide = builder.buildSlide(wish.getStartDate(), wish.getEndDate());
                    slide.setText(new TlText(wish.getName(), PromotionWishType.getNameByCode(wish.getType())));
                    TlMedia media = new TlMedia(wish.getImage());
                    if (PromotionWishType.getValueByCode(wish.getType()) == PromotionWishType.CHARACTER) {
                        media.setThumbnail(String.format(ResourceUrl.CHARACTER_HEAD_IMAGE_URL, wish.getStar5()));
                    }
                    slide.setMedia(media);
                    slide.setGroup(PromotionWishType.getNameByCode(wish.getType()));
                    slide.setUnique_id(getUniqueId(wish));
                    return slide;
                })
                .forEach(builder::addEvent);

        genshinEventService.queryTimeLimitedEventList().stream()
                .filter(event -> EventType.getValueByCode(event.getType()) != EventType.INVITE)
                .map(event -> {
                    TlSlide slide = builder.buildSlide(event.getStartDate(), event.getEndDate());
                    slide.setText(new TlText(event.getName(), event.getDescription()));
                    TlMedia media = new TlMedia(event.getImage());
                    media.setLink(event.getBbsArticleUrl());
                    slide.setMedia(media);
                    slide.setGroup(EventType.getNameByCode(event.getType()));
                    slide.setUnique_id(getUniqueId(event));
                    return slide;
                })
                .forEach(builder::addEvent);

        return builder.build();
    }

    private String getUniqueId(GenshinBattlePassDto battlePass) {
        return "battlePass-" + battlePass.getVersion();
    }

    private String getUniqueId(GenshinPromotionWishEntity wish) {
        return wish.getType() + "-" + wish.getVersion() + "-" + wish.getNumber();
    }

    private String getUniqueId(GenshinEventEntity event) {
        EventType eventType = EventType.getValueByCode(event.getType());
        String prefix = eventType != null ? eventType.getPrefix() : StringUtils.EMPTY;
        return prefix + "-" + event.getName();
    }

}