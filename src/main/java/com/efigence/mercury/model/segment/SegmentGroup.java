package com.efigence.mercury.model.segment;

import lombok.*;

import java.util.List;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class SegmentGroup {

    private final String name;

    @Builder.Default
    private final boolean include = true;

    private final Filter filter;

    @Singular
    private final List<SegmentCondition> conditions;
}
