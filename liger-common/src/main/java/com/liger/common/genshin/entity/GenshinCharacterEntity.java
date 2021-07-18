package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liger.common.genshin.enums.Element;
import com.liger.common.genshin.enums.WeaponType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("genshin__character")
public class GenshinCharacterEntity {

    @TableId(type = IdType.INPUT)
    private String sid;
    private String name;
    private String title;
    private Integer rarity;
    private Element element;
    private WeaponType weaponType;
    private Boolean obtainable;
    private String nameEn;
    private String releaseVersion;
    private Date releaseDate;

}
