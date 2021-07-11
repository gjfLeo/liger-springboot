package com.liger.common.common.model.timeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TlText implements Serializable {

    private String headline;
    private String text;

    public static TlText of(String headline, String text) {
        return new TlText(headline, StringUtils.defaultString(text));
    }

    public static TlText of(String headline) {
        return new TlText(headline, StringUtils.EMPTY);
    }

}
