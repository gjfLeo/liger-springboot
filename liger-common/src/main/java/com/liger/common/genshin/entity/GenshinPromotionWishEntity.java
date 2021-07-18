package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liger.common.genshin.enums.PromotionWishType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "genshin__promotion_wish")
public class GenshinPromotionWishEntity implements Serializable {

    private Integer id;
    private PromotionWishType type;
    private String version;
    private Integer number;
    private String name;
    private Date startDate;
    private Date endDate;
    private String image;
    private String star5;
    private String star4;

}
