package com.liger.common.genshin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liger.common.genshin.entity.GenshinCharacterEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GenshinCharacterMapper extends BaseMapper<GenshinCharacterEntity> {
}
