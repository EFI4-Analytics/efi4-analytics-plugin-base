package com.efigence.mercury.usecase.logic.segment;

import com.efigence.mercury.model.segment.SegmentCondition;
import com.efigence.mercury.usecase.contract.segment.SegmentConditionRequestModel;

public interface SegmentConditionConverter {

    SegmentCondition convert(SegmentConditionRequestModel model);
}
