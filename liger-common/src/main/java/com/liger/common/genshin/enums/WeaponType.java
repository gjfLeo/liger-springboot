package com.liger.common.genshin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WeaponType {

    SWORD(1, "单手剑"),
    CLAYMORE(2, "双手剑"),
    POLEARM(3, "长柄武器"),
    BOW(4, "弓"),
    CATALYST(5, "法器"),
    ;

    @EnumValue
    private final int code;
    private final String name;

}
