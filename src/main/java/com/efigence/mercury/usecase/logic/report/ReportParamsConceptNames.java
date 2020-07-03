package com.efigence.mercury.usecase.logic.report;

import com.efigence.mercury.usecase.contract.segment.SegmentConditionRequestModel;
import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.Collections;
import java.util.List;

import static com.efigence.mercury.model.segment.Constants.ALL_USERS_SEGMENT_NAME;
import static java.util.Collections.singletonList;

@Value
@Builder
public class ReportParamsConceptNames {

    private final List<String> segments;
    @Singular
    private final List<String> dimensions;
    @Singular
    private final List<String> metrics;
    private final List<String> sorts;
    private final List<SegmentConditionRequestModel> filters;

    public static class ReportParamsConceptNamesBuilder {

        private List<String> segments = singletonList(ALL_USERS_SEGMENT_NAME);

        public ReportParamsConceptNamesBuilder segments(List<String> segments) {
            if (segments != null && !segments.isEmpty()) {
                this.segments = segments;
            }
            return this;
        }

        public ReportParamsConceptNamesBuilder sorts(List<String> sorts) {
            this.sorts = sorts == null ? Collections.emptyList() : sorts;
            return this;
        }

        public ReportParamsConceptNamesBuilder sort(String sort) {
            return sorts(ImmutableList.of(sort));
        }
    }

}
