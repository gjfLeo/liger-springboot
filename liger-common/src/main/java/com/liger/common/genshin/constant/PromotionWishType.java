package com.liger.common.genshin.constant;

import lombok.Getter;

@Getter
public enum PromotionWishType {

    CHARACTER("character", "角色活动祈愿"),
    WEAPON("weapon", "武器活动祈愿");

    private final String code;
    private final String name;

    PromotionWishType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static PromotionWishType getValueByCode(String value) {
        for (PromotionWishType promotionWishType : values()) {
            if (promotionWishType.code.equals(value)) return promotionWishType;
        }
        return null;
    }

    public static String getNameByCode(String value) {
        PromotionWishType promotionWishType = getValueByCode(value);
        return promotionWishType != null ? promotionWishType.name : null;
    }

}

