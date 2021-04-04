package com.liger.common.hello.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liger.common.hello.entity.DemoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface DemoMapper extends BaseMapper<DemoEntity> {
}
