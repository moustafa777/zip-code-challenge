package com.williams.model;

import lombok.Data;

@Data
public class Range {
    private int startValue;
    private int endValue;

    public Range(int startValue, int endValue) {
        this.startValue = startValue;
        this.endValue = endValue;
    }
}
