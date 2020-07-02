package com.group.apartment.apartment.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Currency {
    private boolean success;
    private String terms;
    private String privacy;
    private boolean historical;
    private String date;
    private float timestamp;
    private String source;
    private Quotes quotes;



}
