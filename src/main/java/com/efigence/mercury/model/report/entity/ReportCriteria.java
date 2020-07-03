package com.efigence.mercury.model.report.entity;

import com.efigence.mercury.model.report.entity.pagination.SortCriteria;
import com.efigence.mercury.model.segment.Segment;
import com.efigence.mercury.model.segment.SegmentCondition;
import com.google.common.base.MoreObjects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@EqualsAndHashCode
@ToString
@Getter
public class ReportCriteria {

    private final List<Segment> segments;
    private final List<Dimension> dimensions;
    private final List<Metric> metrics;
    private final List<SortCriteria> sortCriteria;
    private final List<SegmentCondition> filters;

    public ReportCriteria(List<Segment> segments, List<Dimension> dimensions, List<Metric> metrics,
            List<SortCriteria> sortCriteria, List<SegmentCondition> filters) {
        this.segments = segments;
        this.dimensions = dimensions;
        this.metrics = metrics;
        this.sortCriteria = validate(MoreObjects.firstNonNull(sortCriteria, emptyList()));
        this.filters = filters;
    }

    public final List<SortCriteria> validate(List<SortCriteria> sortCriteria) {
        List<String> conceptNames = getColumnConceptNames();
        Optional<SortCriteria> invalidSort = sortCriteria.stream()
                .filter(sortColumn -> !conceptNames.contains(sortColumn.getComponent().getConceptName()))
                .findFirst();
        invalidSort.ifPresent(this::throwInvalid);
        return sortCriteria;
    }

    private void throwInvalid(SortCriteria s) {
        throw new IllegalArgumentException(
                format("Column '%s' not exist in metric/dimension list", s.getComponent().getConceptName()));
    }

    public List<String> getColumnConceptNames() {
        Stream<String> dimensionConceptNames = dimensions.stream().map(Dimension::getConceptName);
        Stream<String> metricConceptNames = metrics.stream().map(Metric::getConceptName);
        return Stream.concat(dimensionConceptNames, metricConceptNames)
                .collect(toList());
    }

    public List<PartialReportCriteria> partialCriteria() {
        return segments.stream()
                .map(this::partialReportCriteria)
                .collect(toList());
    }

    private PartialReportCriteria partialReportCriteria(Segment segment) {
        return PartialReportCriteria.builder()
                .segment(segment)
                .metrics(metrics)
                .dimensions(dimensions)
                .sortCriteria(sortCriteria)
                .filters(filters)
                .build();
    }

    public Optional<Metric> getMetric(String conceptName) {
        return metrics.stream()
                .filter(d -> d.getConceptName().equals(conceptName))
                .findFirst();
    }

    public Optional<Dimension> getDimension(String conceptName) {
        return dimensions.stream()
                .filter(d -> d.getConceptName().equals(conceptName))
                .findFirst();
    }

    public Optional<Segment> getSegment(String segmentId) {
        return segments.stream()
                .filter(s -> s.getSegmentId().equals(segmentId))
                .findFirst();
    }

    public int getMetricsCount() {
        return metrics.size();
    }
}