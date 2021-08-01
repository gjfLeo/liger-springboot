package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "genshin__data_text_map")
public class GenshinDataTextMapEntity {

    @TableId(type = IdType.INPUT)
    private Long id;
    private String text;

}
