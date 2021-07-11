package com.liger.common.genshin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class GenshinVersionDto implements Serializable {

    private String version;
    private String name;
    private Date startDate;
    private Date endDate;
    private String pv;
    private String previewImage;
    private String previewPage;

}
