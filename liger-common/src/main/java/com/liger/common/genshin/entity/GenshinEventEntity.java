package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("genshin_event")
public class GenshinEventEntity {

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
