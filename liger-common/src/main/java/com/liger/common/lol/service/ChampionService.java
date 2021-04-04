package com.liger.common.lol.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liger.common.common.constant.LigerDataSource;
import com.liger.common.common.result.LigerResult;
import com.liger.common.common.util.HttpRequestUtils;
import com.liger.common.common.util.LigerBeanUtils;
import com.liger.common.lol.constant.ResourceUrl;
import com.liger.common.lol.dto.source.ChampionInfoSourceDto;
import com.liger.common.lol.dto.source.ChampionListSourceDto;
import com.liger.common.lol.entity.ChampionInfoEntity;
import com.liger.common.lol.mapper.ChampionInfoMapper;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@DS(LigerDataSource.LOL)
public class ChampionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChampionService.class);

    @Autowired
    private ChampionInfoMapper championInfoMapper;

    public LigerResult<?> updateChampionInfo() {
        String url = ResourceUrl.getChampionListUrl();
        try {
            ChampionListSourceDto championListSourceDto = HttpRequestUtils.get(url, ChampionListSourceDto.class);
            int result = championListSourceDto.getHero().stream()
                    .map(LigerBeanUtils.converter(ChampionInfoEntity::new))
                    .mapToInt(entity -> {
                        if (championInfoMapper.selectById(entity.getChampionId()) == null) {
                            return championInfoMapper.insert(entity);
                        } else {
                            return championInfoMapper.updateById(entity);
                        }
                    })
                    .sum();
            return LigerResult.ok(result);
        } catch (Exception e) {
            return LigerResult.error(e);
        }
    }

    public LigerResult<?> updateChampionInfoFull() {
        List<String> failUrl = new ArrayList<>();
        int row = championInfoMapper.selectList(new QueryWrapper<>()).stream()
//                .parallel()
                .map(ChampionInfoEntity::getChampionId)
                .map(ResourceUrl::getChampionInfoUrl)
                .map(url -> {
                    try {
                        return HttpRequestUtils.get(url, ChampionInfoSourceDto.class);
                    } catch (IOException e) {
                        LOGGER.error("英雄信息获取失败, url:{}", url, e);
                        failUrl.add(url);
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .map(ChampionInfoSourceDto::getHero)
                .map(LigerBeanUtils.converter(ChampionInfoEntity::new))
                .mapToInt(entity -> {
                    if (championInfoMapper.selectById(entity.getChampionId()) == null) {
                        return championInfoMapper.insert(entity);
                    } else {
                        return championInfoMapper.updateById(entity);
                    }
                })
                .sum();
        Map<String, Object> result = new HashMap<>(2);
        result.put("row", row);
        result.put("fail", failUrl);
        return LigerResult.ok(result);
    }

    public List<ChampionInfoEntity> getChampionInfoList() {
        return championInfoMapper.selectList(new QueryWrapper<>()).stream()
                .peek(entity -> entity.setShortBio(null))
                .collect(Collectors.toList());
    }

    public ChampionInfoEntity getChampionInfoById(@NonNull Integer championId, boolean isFull) {
        ChampionInfoEntity entity = championInfoMapper.selectById(championId);
        if (!isFull) {
            entity.setShortBio(null);
        }
        return entity;
    }

}
