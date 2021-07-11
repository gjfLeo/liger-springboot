package com.liger.common.common.model.timeline;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class TlData {
    public static final String SCALE_HUMAN = "human";
    public static final String SCALE_COSMOLOGICAL = "cosmological";
    private TlSlide title;
    private List<TlSlide> events;
    private List<TlEra> eras;
    private String scale;
}
