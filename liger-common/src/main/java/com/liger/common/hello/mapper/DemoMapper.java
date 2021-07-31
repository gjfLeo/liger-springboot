package com.liger.common.hello.mapper;

import com.liger.common.common.mybatis.LigerBaseMapper;
import com.liger.common.hello.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DemoMapper extends LigerBaseMapper<DemoEntity> {
}
