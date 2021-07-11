package com.liger.common.common.model.timeline;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TlEra {
    private TlDate start_date;
    private TlDate end_date;
    private TlText text;
}
