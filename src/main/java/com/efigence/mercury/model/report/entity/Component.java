package com.efigence.mercury.model.report.entity;

import com.efigence.mercury.model.report.entity.pagination.SortDirection;

public interface Component extends Descriptable, Sortable, Comparable<Component> {
    Group getGroup();
    ValueType getValueType();
    boolean isAllowedInSegment();
    boolean isInternal();
    SortDirection getSortDirection();
    String getConceptPrefix();
    String getName();
    default Scope getDefaultScope() {
        throw new UnsupportedOperationException();
    }
    // TODO: filter should be removed when all metrics will be implemented
    default boolean isImplemented() {
        return false;
    }
}
