package com.liger.common.genshin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liger.common.genshin.entity.GenshinVersionEntity;
import com.liger.common.genshin.mapper.GenshinVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GenshinVersionService {

    @Autowired
    private GenshinVersionMapper versionMapper;

    public List<GenshinVersionEntity> queryVersionList() {
        return versionMapper.selectList(new QueryWrapper<>());
    }

    public Map<String, GenshinVersionEntity> queryVersionMap() {
        List<GenshinVersionEntity> versionList = this.queryVersionList();
        return versionList.stream()
                .collect(Collectors.toMap(GenshinVersionEntity::getVersion, Function.identity()));
    }

    public GenshinVersionEntity queryVersion(String version) {
        QueryWrapper<GenshinVersionEntity> wrapper = new QueryWrapper<GenshinVersionEntity>()
                .eq("version", version);
        return versionMapper.selectOne(wrapper);
    }

}
