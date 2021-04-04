package com.liger.common.lol.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@AllArgsConstructor
public enum DamageType {

    PHYSICAL(1, "kPhysical", "物理伤害"),
    MAGIC(2, "kMagic", "魔法伤害"),
    MIXED(10, "kMixed", "混合伤害"),
    ;

    private static final Logger LOGGER = LoggerFactory.getLogger(DamageType.class);
    private final int id;
    private final String key;
    private final String name;

    public static int getIdByKey(String key) {
        for (DamageType damageType : values()) {
            if (damageType.key.equals(key)) {
                return damageType.id;
            }
        }
        LOGGER.warn("未知的DamageTypeKey: {}", key);
        return 0;
    }

}