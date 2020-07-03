package com.efigence.mercury.usecase.contract.segment;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import lombok.experimental.Tolerate;

/**
 * used for filtering within report {@link GenerateReportRequestModel}
 */
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SegmentConditionRequestModel {
    Long id;
    String groupOperator;
    String componentConceptName;
    String componentScope;
    String operatorConceptName;
    String parameter;

    @Tolerate
    public SegmentConditionRequestModel() {
        // for mapper
    }
}