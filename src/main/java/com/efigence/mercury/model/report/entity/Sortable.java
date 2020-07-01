package com.efigence.mercury.model.report.entity;

import com.efigence.mercury.model.report.entity.pagination.SortDirection;

public interface Sortable extends Nameable {
    SortDirection getSortDirection();
}
