package com.liger.local.genshin.mapper;

import com.liger.common.common.mybatis.LigerBaseMapper;
import com.liger.common.genshin.entity.GenshinDataMaterialEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GenshinDataMaterialMapper extends LigerBaseMapper<GenshinDataMaterialEntity> {
}
