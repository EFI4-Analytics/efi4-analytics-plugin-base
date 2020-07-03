package com.efigence.mercury.model.report.gateway;

import com.efigence.mercury.model.report.entity.Metric;

import java.util.List;

public interface MetricRepository {
    Metric findByConceptName(String conceptName);
    List<Metric> findAll();
}
