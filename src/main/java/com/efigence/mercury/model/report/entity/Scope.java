package com.efigence.mercury.model.report.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Scope {
    USER_LTV(4),
    USER(3),
    SESSION(2),
    HIT(1);

    @Getter
    private final int level;
}
