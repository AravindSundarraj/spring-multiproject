package com.group.apartment.apartment.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class Quotes {

    private BigDecimal USDUSD;
    private BigDecimal USDAUD;
    private BigDecimal USDCAD;
    private BigDecimal USDPLN;
    private BigDecimal USDMXN;
    private BigDecimal USDINR;
    private BigDecimal USDJPY;
}
