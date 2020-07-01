package com.efigence.mercury.model.segment;

import lombok.*;
import lombok.experimental.Tolerate;

import static com.efigence.mercury.model.segment.GroupOperator.AND;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class SegmentCondition {

    @Builder.Default
    private GroupOperator groupOperator = AND;
    private ComponentScope componentScope;
    private AllowedInSegment component;
    private Operator operator;
    private String parameter;

    @Tolerate
    SegmentCondition() {
        // for mapper
    }
}
