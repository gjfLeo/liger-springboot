package com.liger.common.genshin.service;

import com.liger.common.genshin.dto.GenshinVersionDto;
import com.liger.common.genshin.mapper.GenshinVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenshinVersionService {

    @Autowired
    private GenshinVersionMapper genshinVersionMapper;

    public List<GenshinVersionDto> queryVersionList() {
        return genshinVersionMapper.selectVersionList();
    }

}
