package com.liger.common.common.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface LigerBaseMapper<T> extends BaseMapper<T> {

    int replace(T entity);

}
