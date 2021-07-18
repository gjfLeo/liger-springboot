package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liger.common.genshin.intf.HasBbsArticle;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("genshin__battle_pass_view")
public class GenshinBattlePassEntity implements Serializable, HasBbsArticle {

    private Integer id;
    private String version;
    private String name;
    private Date startDate;
    private Date endDate;
    private String image;
    private Integer bbsArticleId;

}
