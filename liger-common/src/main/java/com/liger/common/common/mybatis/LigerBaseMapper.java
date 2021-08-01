package com.liger.common.common.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LigerBaseMapper<T> extends BaseMapper<T> {

    /** 批量插入 */
    // 如果要自动填充，@{@code Param}(xx) xx参数名必须是 list/collection/array 3个的其中之一
    int batchInsert(@Param("list") List<T> list);

    /** 替换 ({@code REPLACE}) */
    int replace(T entity);


    /** 批量替换 ({@code REPLACE}) */
    int batchReplace(@Param("list") List<T> list);

    /** 删除全部行 */
    int deleteAll();

    /** 清空表 */
    int truncate();

}
