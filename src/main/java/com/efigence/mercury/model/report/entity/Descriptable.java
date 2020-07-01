package com.efigence.mercury.model.report.entity;

public interface Descriptable extends Nameable {
    String DESCRIPTION_SUFFIX = ".description";
    String getConceptDescription();
}
