package com.liger.common.genshin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liger.common.common.util.PredicateUtils;
import com.liger.common.genshin.dto.GenshinVersionDto;
import com.liger.common.genshin.entity.GenshinPromotionWishEntity;
import com.liger.common.genshin.mapper.GenshinPromotionWishMapper;
import com.liger.common.genshin.mapper.GenshinVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GenshinWishService {

    @Autowired
    private GenshinPromotionWishMapper genshinPromotionWishMapper;
    @Autowired
    private GenshinVersionService genshinVersionService;

    public List<GenshinPromotionWishEntity> queryPromotionWishList() {

        Map<String, GenshinVersionDto> versionMap = genshinVersionService.queryVersionMap();

        List<GenshinPromotionWishEntity> wishList = genshinPromotionWishMapper.selectList(new QueryWrapper<>());
        wishList.stream()
                .filter(PredicateUtils.fieldIsNull(GenshinPromotionWishEntity::getStartDate))
                .forEach(wish -> {
                    String versionNumber = wish.getVersion();
                    GenshinVersionDto version = versionMap.get(versionNumber);
                    wish.setStartDate(version.getStartDate());
                });

        return wishList;

    }

}
