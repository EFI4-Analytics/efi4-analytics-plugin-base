package com.efigence.mercury.model.report.entity;

public interface Metric extends Component {
    @Override
    default String getConceptPrefix() {
        return "metric.";
    }
}
