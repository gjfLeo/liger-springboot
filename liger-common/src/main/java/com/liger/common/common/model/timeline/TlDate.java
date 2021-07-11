package com.liger.common.common.model.timeline;

import lombok.Data;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;

@Data
public class TlDate {
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer second;
    private Integer millisecond;
    private String display_date;
}
