package com.liger.common.genshin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum Element {

    HYDRO(1, "水"),
    PYRO(2, "火"),
    ANEMO(3, "风"),
    ELECTRO(4, "雷"),
    DENDRO(5, "草"),
    CYRO(6, "冰"),
    GEO(7, "岩");

    @EnumValue
    private final int id;
    private final String name;

    Element(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Element getElementById(Integer id) {
        for (Element value : values()) {
            if (value.id == id) return value;
        }
        return null;
    }

}
