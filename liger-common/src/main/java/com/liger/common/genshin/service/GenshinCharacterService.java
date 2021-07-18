package com.liger.common.genshin.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liger.common.genshin.entity.GenshinCharacterEntity;
import com.liger.common.genshin.mapper.GenshinCharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenshinCharacterService {

    @Autowired
    private GenshinCharacterMapper characterMapper;

    public List<GenshinCharacterEntity> list(GenshinCharacterEntity param) {
        QueryWrapper<GenshinCharacterEntity> wrapper = new QueryWrapper<>();
        wrapper = wrapper.select("sid", "name", "title", "rarity", "element", "weapon_type");
        if (param.getRarity() != null)
            wrapper = wrapper.eq("rarity", param.getRarity());
        if (param.getElement() != null)
            wrapper = wrapper.eq("element", param.getElement());
        if (param.getWeaponType() != null)
            wrapper = wrapper.eq("weapon_type", param.getWeaponType());
        if (param.getObtainable() != null)
            wrapper = wrapper.eq("obtainable", param.getObtainable());
        return characterMapper.selectList(wrapper);
    }

}
