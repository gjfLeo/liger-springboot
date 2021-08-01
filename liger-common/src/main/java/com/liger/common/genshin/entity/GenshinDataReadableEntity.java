package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("genshin__data_readable")
public class GenshinDataReadableEntity {

    @TableId(type = IdType.INPUT)
    private String file;
    private String content;

}
