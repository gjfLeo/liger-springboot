package com.liger.common.lol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liger.common.lol.entity.ChampionInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ChampionInfoMapper extends BaseMapper<ChampionInfoEntity> {
}
