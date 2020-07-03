package com.efigence.mercury.model.user.common.entity;

import com.efigence.mercury.model.report.entity.Dimension;
import com.efigence.mercury.model.report.entity.Metric;
import com.efigence.mercury.model.report.entity.pagination.SortCriteria;
import com.efigence.mercury.model.segment.Segment;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class UserReport {
    private final UUID reportId;
    private final UUID watUserId;
    private final String name;
    private final List<Metric> metrics;
    private final List<Dimension> dimensions;
    private final List<Segment> segments;
    private final List<SortCriteria> sortCriteria;
    private final Boolean bookmarked;
    private final Boolean favourite;
}
