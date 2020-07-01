package com.efigence.mercury.segment.custom.delivery;

import com.efigence.mercury.delivery.segment.SegmentConditionDTO;
import com.efigence.mercury.model.segment.Segment;
import com.efigence.mercury.model.segment.SegmentCondition;
import com.efigence.mercury.model.segment.SegmentGroup;
import lombok.NoArgsConstructor;

import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SegmentConverter {

    public static SegmentDTO getSegment(Segment segment) {
        return SegmentDTO.builder()
                .segmentId(segment.getSegmentId())
                .name(segment.getName())
                .isPublic(segment.isPublic())
                .isSystem(segment.isSystem())
                .groups(segment.getGroups().stream()
                        .map(SegmentConverter::getGroup)
                        .collect(toList()))
                .build();
    }

    private static SegmentGroupDTO getGroup(SegmentGroup group) {
        return SegmentGroupDTO.builder()
                .name(group.getName())
                .include(group.isInclude())
                .filter(group.getFilter())
                .conditions(group.getConditions().stream()
                        .map(SegmentConverter::getCondition)
                        .collect(toList()))
                .build();
    }

    private static SegmentConditionDTO getCondition(SegmentCondition condition) {
        return SegmentConditionDTO.builder()
                .groupOperator(condition.getGroupOperator().toString())
                .componentConceptName(condition.getComponent().getConceptName())
                .operatorConceptName(condition.getOperator().getConceptName())
                .parameter(condition.getParameter())
                .build();
    }
}
