package com.liger.common.genshin.util;

public abstract class GenshinUtils {

    public static final String BBS_ARTICLE_URL_FORMAT = "https://bbs.mihoyo.com/ys/article/%s";

    public static String getBbsArticleUrl(int bbsArticleId) {
        return String.format(BBS_ARTICLE_URL_FORMAT, bbsArticleId);
    }

}
