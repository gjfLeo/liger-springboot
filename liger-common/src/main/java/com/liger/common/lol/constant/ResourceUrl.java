package com.liger.common.lol.constant;

import lombok.NonNull;

public abstract class ResourceUrl {

    private static final String CHAMPION_LIST = "https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js";
    private static final String CHAMPION_INFO = "https://game.gtimg.cn/images/lol/act/img/js/hero/%d.js";

    /**
     * {@link com.liger.common.lol.dto.source.ChampionListSourceDto}
     */
    public static String getChampionListUrl() {
        return CHAMPION_LIST;
    }

    /**
     * {@link com.liger.common.lol.dto.source.ChampionInfoSourceDto}
     */
    public static String getChampionInfoUrl(@NonNull Integer championId) {
        return String.format(CHAMPION_INFO, championId);
    }

}