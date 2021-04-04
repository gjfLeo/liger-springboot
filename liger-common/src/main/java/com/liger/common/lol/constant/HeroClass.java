package com.liger.common.lol.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeroClass {

    MAGE("mage", "法师"),
    ASSASSIN("assassin", "刺客"),
    ;

    public final String key;
    public final String name;

}
