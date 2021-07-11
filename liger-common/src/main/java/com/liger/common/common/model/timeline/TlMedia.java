package com.liger.common.common.model.timeline;

import lombok.Data;

@Data
public class TlMedia {
    private String url;
    private String caption;
    private String credit;
    private String thumbnail;
    private String alt;
    private String title;
    private String link;
    private String link_target;

    public TlMedia(String url) {
        this.url = url;
    }

    public TlMedia(String url, String caption) {
        this.url = url;
        this.caption = caption;
    }

}
