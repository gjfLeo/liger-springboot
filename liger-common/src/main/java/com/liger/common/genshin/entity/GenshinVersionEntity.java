package com.liger.common.genshin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName(value = "genshin__version_view")
public class GenshinVersionEntity implements Serializable {

    private Long id;
    private String version;
    private String name;

    private Date startDate;
    private Date endDate;

    private String pv;
    private String previewImage;
    private String previewPage;

    private Integer pvNewsId;
    private Integer previewNewsId;
    private Integer updateNewsId;

}
