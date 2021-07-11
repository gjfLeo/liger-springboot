package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liger.common.genshin.intf.HasBbsArticle;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("genshin_event")
public class GenshinEventEntity implements Serializable, HasBbsArticle {

    private Long id;
    private String name;
    private String subtitle;
    private String type;
    private Date startDate;
    private Date endDate;
    private String version;
    private String description;
    private String image;
    private Integer bbsArticleId;

}
