package com.liger.common.genshin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liger.common.genshin.entity.GenshinBattlePassEntity;
import com.liger.common.genshin.entity.GenshinEventEntity;
import com.liger.common.genshin.entity.GenshinVersionEntity;
import com.liger.common.genshin.mapper.GenshinBattlePassMapper;
import com.liger.common.genshin.mapper.GenshinEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GenshinEventService {

    @Autowired
    private GenshinEventMapper genshinEventMapper;
    @Autowired
    private GenshinVersionService genshinVersionService;
    @Autowired
    private GenshinBattlePassMapper genshinBattlePassMapper;

    public List<GenshinEventEntity> queryEventList() {
        List<GenshinEventEntity> eventList = genshinEventMapper.selectList(new QueryWrapper<>());
        Map<String, GenshinVersionEntity> versionMap = genshinVersionService.queryVersionMap();
        eventList.stream()
                .filter(event -> event.getVersion() != null)
                .filter(event -> event.getStartDate() == null || event.getEndDate() == null)
                .forEach(event -> {
                    String versionNumber = event.getVersion();
                    GenshinVersionEntity version = versionMap.get(versionNumber);
                    if (event.getStartDate() == null)
                        event.setStartDate(version.getStartDate());
                    if (event.getEndDate() == null)
                        event.setEndDate(version.getEndDate());
                });
        return eventList;
    }

    public List<GenshinEventEntity> queryTimeLimitedEventList() {
        return queryEventList().stream()
                .filter(event -> event.getStartDate() != null)
                .filter(event -> event.getEndDate() != null)
                .collect(Collectors.toList());
    }

    public List<GenshinBattlePassEntity> queryBattlePassList() {
        return genshinBattlePassMapper.selectList(new QueryWrapper<>());
    }

}
