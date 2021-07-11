package com.liger.common.genshin.constant;

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

    private final int id;
    private final String name;

    Element(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
