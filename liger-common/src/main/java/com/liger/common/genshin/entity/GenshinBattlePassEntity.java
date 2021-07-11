package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liger.common.genshin.intf.HasBbsArticle;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

@Getter
@TableName("genshin_battle_pass")
public class GenshinBattlePassEntity implements Serializable, HasBbsArticle {

    private Integer id;
    private String version;
    private String name;
    private Date endDate;
    private String image;
    private Integer bbsArticleId;

}
