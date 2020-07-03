package com.efigence.mercury.model.segment;

import lombok.Builder;
import lombok.Getter;

import java.math.BigInteger;

@Builder
@Getter
public class SegmentStats {
    private final Segment segment;
    private final int usersPercent;
    private final BigInteger users;
    private final int sessionsPercent;
    private final BigInteger sessions;
}
