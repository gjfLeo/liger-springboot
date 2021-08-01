package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("genshin__data_equip_affix")
public class GenshinDataEquipAffixEntity {

    private Integer id;
    private Integer affixId;
    private Long nameTextMapHash;
    private Long descTextMapHash;
    private Integer level;
    private String openConfig;

}
