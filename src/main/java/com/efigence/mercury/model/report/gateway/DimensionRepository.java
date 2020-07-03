package com.efigence.mercury.model.report.gateway;

import com.efigence.mercury.model.report.entity.Dimension;

import java.util.List;

public interface DimensionRepository {
    Dimension findByConceptName(String conceptName);
    List<Dimension> findAll();
}
