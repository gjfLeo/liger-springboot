package com.liger.common.genshin.service;

import com.liger.common.genshin.dto.GenshinVersionDto;
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
    private GenshinVersionMapper genshinVersionMapper;

    public List<GenshinVersionDto> queryVersionList() {
        return genshinVersionMapper.selectVersionList();
    }

    public Map<String, GenshinVersionDto> queryVersionMap() {
        List<GenshinVersionDto> versionList = this.queryVersionList();
        return versionList.stream()
                .collect(Collectors.toMap(GenshinVersionDto::getVersion, Function.identity()));
    }

}
