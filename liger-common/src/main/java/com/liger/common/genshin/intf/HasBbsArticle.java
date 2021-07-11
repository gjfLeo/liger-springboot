package com.liger.common.genshin.intf;

public interface HasBbsArticle {

    String BBS_ARTICLE_URL_FORMAT = "https://bbs.mihoyo.com/ys/article/%s";

    Integer getBbsArticleId();

    default String getBbsArticleUrl() {
        return String.format(BBS_ARTICLE_URL_FORMAT, getBbsArticleId());
    }

}
