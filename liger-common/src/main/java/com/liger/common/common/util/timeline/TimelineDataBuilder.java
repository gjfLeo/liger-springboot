package com.liger.common.common.util.timeline;

import com.liger.common.common.model.timeline.*;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.*;

public class TimelineDataBuilder {

    private TlSlide title;
    private List<TlSlide> events;
    private List<TlEra> eras;
    @Setter
    private String scale;

    private int dateField = Calendar.MINUTE;
    private String datePattern = "yyyy-MM-dd HH:mm:ss";

    public TimelineDataBuilder() {
        this.title = new TlSlide();
        this.events = new ArrayList<>();
        this.eras = new ArrayList<>();
    }

    public TimelineDataBuilder setDateField(int dateField) {
        this.dateField = dateField;
        return this;
    }

    public TimelineDataBuilder setDatePattern(String datePattern) {
        this.datePattern = datePattern;
        return this;
    }

    public TlData build() {
        return new TlData(title, events, eras, scale);
    }

    public TimelineDataBuilder setTitleText(String headline, String text) {
        this.title.setText(TlText.of(headline, text));
        return this;
    }

    public TimelineDataBuilder setTitleText(String headline) {
        return this.setTitleText(headline, StringUtils.EMPTY);
    }

    public TlDate buildDate(Date date) {
        TlDate tlDate = new TlDate();
        tlDate.setDisplay_date(DateFormatUtils.format(date, datePattern));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        if (dateField < Calendar.YEAR) return tlDate;
        tlDate.setYear(calendar.get(Calendar.YEAR));

        if (dateField < Calendar.MONTH) return tlDate;
        tlDate.setMonth(calendar.get(Calendar.MONTH) + 1);

        if (dateField < Calendar.DAY_OF_MONTH) return tlDate;
        tlDate.setDay(calendar.get(Calendar.DAY_OF_MONTH));

        if (dateField < Calendar.HOUR_OF_DAY) return tlDate;
        tlDate.setHour(calendar.get(Calendar.HOUR_OF_DAY));

        if (dateField < Calendar.MINUTE) return tlDate;
        tlDate.setMinute(calendar.get(Calendar.MINUTE));

        if (dateField < Calendar.SECOND) return tlDate;
        tlDate.setSecond(calendar.get(Calendar.SECOND));

        return tlDate;
    }

    public TlEra buildEra(Date startDate, Date endDate, String headline) {
        return new TlEra(this.buildDate(startDate), this.buildDate(endDate), TlText.of(headline));
    }

    public TimelineDataBuilder addEra(TlEra era) {
        this.eras.add(era);
        return this;
    }

    public TimelineDataBuilder addEra(Collection<TlEra> era) {
        this.eras.addAll(era);
        return this;
    }

    public TlSlide buildSlide(Date startDate) {
        return this.buildSlide(startDate, null);
    }

    public TlSlide buildSlide(Date startDate, Date endDate) {
        TlSlide slide = new TlSlide();
        slide.setStart_date(this.buildDate(startDate));
        slide.setEnd_date(this.buildDate(endDate));
        return slide;
    }

    public TimelineDataBuilder addEvent(TlSlide slide) {
        this.events.add(slide);
        return this;
    }

    public TimelineDataBuilder addEvent(Collection<TlSlide> slide) {
        this.events.addAll(slide);
        return this;
    }

}
