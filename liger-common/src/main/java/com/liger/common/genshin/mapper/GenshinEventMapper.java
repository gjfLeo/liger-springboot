package com.liger.common.genshin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liger.common.genshin.entity.GenshinEventEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GenshinEventMapper extends BaseMapper<GenshinEventEntity> {
}
