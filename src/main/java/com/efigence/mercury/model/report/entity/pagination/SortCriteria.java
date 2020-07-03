package com.efigence.mercury.model.report.entity.pagination;

import com.efigence.mercury.model.report.entity.Component;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class SortCriteria {
    public static final String DELIMITER = "-";

    private final Component component;
    private final SortDirection sortDirection;

    public String getStringRepresentation() {
        return component.getConceptName() + DELIMITER + sortDirection;
    }
}
