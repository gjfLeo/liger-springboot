package com.liger.common.common.model.timeline;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TlSlide {
    private TlDate start_date;
    private TlDate end_date;
    private TlText text;
    private TlMedia media;
    private String group;
    private String display_date;
    private TlBackground background;
    private Boolean autolink;
    private String unique_id;
}
