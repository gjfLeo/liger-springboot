package com.liger.common.genshin.dto;

import lombok.Data;

@Data
public class GenshinCharacterEntity {

    private String key;

    public String getHeadImageUrl() {
        return "https://cdn.jsdelivr.net/gh/gjfLeo/genshin-assets@latest/character/" + key + ".png";
    }

}
