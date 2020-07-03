package com.efigence.mercury.model.report.gateway;

import com.efigence.mercury.model.report.entity.Component;
import com.efigence.mercury.model.segment.AllowedInSegment;

public interface ComponentRepository {
    Component findByConceptName(String conceptName);
    AllowedInSegment allowedInSegmentByConceptName(String conceptName);
}
