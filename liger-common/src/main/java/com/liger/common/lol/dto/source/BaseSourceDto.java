package com.liger.common.lol.dto.source;

import lombok.Data;

@Data
public abstract class BaseSourceDto {

    private String version;
    private String fileName;
    private String fileTime;

}
