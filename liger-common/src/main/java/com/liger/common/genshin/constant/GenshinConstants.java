package com.liger.common.genshin.constant;

import lombok.Getter;

public abstract class GenshinConstants {

    @Getter
    public enum EventType {

        IN_GAME("in-game", "游戏内活动", "inGame"),
        WEB("web", "网页活动", "web"),
        INVITE("invite", "招募活动", "invite");

        private final String value;
        private final String name;
        private final String prefix;

        EventType(String value, String name, String prefix) {
            this.value = value;
            this.name = name;
            this.prefix = prefix;
        }

        public static EventType getEventTypeByValue(String value) {
            for (EventType eventType : values()) {
                if (eventType.value.equals(value)) return eventType;
            }
            return null;
        }

        public static String getNameByValue(String value) {
            EventType eventType = getEventTypeByValue(value);
            return eventType != null ? eventType.name : null;
        }

    }

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

}
