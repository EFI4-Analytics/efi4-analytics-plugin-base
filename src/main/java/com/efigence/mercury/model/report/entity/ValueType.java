package com.efigence.mercury.model.report.entity;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public enum ValueType {
    STRING, INTEGER, DECIMAL, PERCENT, DATE, SECONDS, TIME, CURRENCY, USER;

    public static Set<ValueType> getNumericTypes() {
        return ImmutableSet.<ValueType>builder()
                .add(INTEGER)
                .addAll(getDecimalTypes())
                .build();
    }

    public boolean isNumeric() {
        return getNumericTypes().contains(this);
    }

    public static Set<ValueType> getDecimalTypes() {
        return ImmutableSet.of(DECIMAL, PERCENT, CURRENCY, SECONDS);
    }
}
