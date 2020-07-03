package com.efigence.mercury.model.report.entity;

import com.efigence.mercury.model.report.entity.pagination.SortCriteria;
import com.efigence.mercury.model.segment.Segment;
import com.efigence.mercury.model.segment.SegmentCondition;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

import static java.util.Objects.requireNonNull;

@EqualsAndHashCode
@ToString
@Getter
@Builder(toBuilder = true)
public class PartialReportCriteria {

    private static final int MAX_REPORT_SIZE = 5000;
    private final Segment segment;
    private final List<Metric> metrics;
    private final List<Dimension> dimensions;
    private final List<SortCriteria> sortCriteria;
    private final List<SegmentCondition> filters;

    @Builder
    public PartialReportCriteria(Segment segment, List<Metric> metrics, List<Dimension> dimensions,
            List<SortCriteria> sortCriteria, List<SegmentCondition> filters) {
        this.segment = segment;
        this.sortCriteria = requireNonNull(sortCriteria);
        this.metrics = requireNonNull(metrics);
        this.dimensions = requireNonNull(dimensions);
        this.filters = filters;
    }

    public int getMaxReportSize() {
        return MAX_REPORT_SIZE;
    }
}
