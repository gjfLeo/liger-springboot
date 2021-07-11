package com.liger.common.genshin.constant;

import lombok.Getter;

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

    public static EventType getValueByCode(String value) {
        for (EventType eventType : values()) {
            if (eventType.value.equals(value)) return eventType;
        }
        return null;
    }

    public static String getNameByCode(String value) {
        EventType eventType = getValueByCode(value);
        return eventType != null ? eventType.name : null;
    }

}
