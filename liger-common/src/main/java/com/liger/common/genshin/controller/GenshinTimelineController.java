package com.liger.common.genshin.controller;

import com.liger.common.common.model.timeline.TlData;
import com.liger.common.common.model.timeline.TlMedia;
import com.liger.common.common.model.timeline.TlSlide;
import com.liger.common.common.model.timeline.TlText;
import com.liger.common.common.result.ResultResponseBody;
import com.liger.common.common.util.timeline.TimelineDataBuilder;
import com.liger.common.genshin.constant.GenshinConstants;
import com.liger.common.genshin.entity.GenshinEventEntity;
import com.liger.common.genshin.service.GenshinEventService;
import com.liger.common.genshin.service.GenshinVersionService;
import com.liger.common.genshin.util.GenshinUtils;
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

        genshinEventService.queryTimeLimitedEventList().stream()
                .map(event -> {
                    TlSlide slide = builder.buildSlide(event.getStartDate(), event.getEndDate());
                    slide.setText(new TlText(event.getName(), event.getDescription()));
                    TlMedia media = new TlMedia(event.getImage());
                    media.setLink(GenshinUtils.getBbsArticleUrl(event.getBbsArticleId()));
                    media.setThumbnail("");
                    slide.setMedia(media);
                    slide.setGroup(GenshinConstants.EventType.getNameByValue(event.getType()));
                    slide.setUnique_id(getUniqueId(event));
                    return slide;
                })
                .forEach(builder::addEvent);

        return builder.build();
    }

    private String getUniqueId(GenshinEventEntity event) {
        GenshinConstants.EventType eventType = GenshinConstants.EventType.getEventTypeByValue(event.getType());
        String prefix = eventType != null ? eventType.getPrefix() : StringUtils.EMPTY;
        return prefix + event.getName();
    }

}