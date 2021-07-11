package com.liger.common.common.model.timeline;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TlBackground {
    private String url;
    private String color;

    public static TlBackground url(String url) {
        return new TlBackground(url, null);
    }
}
