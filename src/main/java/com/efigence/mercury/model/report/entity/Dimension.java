package com.efigence.mercury.model.report.entity;

public interface Dimension extends Component {
    default String getConceptPrefix() {
        return "dimension.";
    }
}
