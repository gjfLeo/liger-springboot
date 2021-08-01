package com.liger.local.genshin.mapper;

import com.liger.common.common.mybatis.LigerBaseMapper;
import com.liger.common.genshin.entity.GenshinDataSubtitleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GenshinDataSubtitleMapper extends LigerBaseMapper<GenshinDataSubtitleEntity> {
}
