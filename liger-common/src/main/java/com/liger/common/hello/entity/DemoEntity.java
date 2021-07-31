package com.liger.common.hello.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("demo")
public class DemoEntity {

    @TableId(type = IdType.INPUT)
    private String id;

    private String name;

}
