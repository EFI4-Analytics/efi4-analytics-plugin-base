package com.efigence.mercury.usecase.logic.report;

import com.efigence.mercury.model.report.entity.ReportCriteria;

public interface ReportCriteriaFactory {

    ReportCriteria createReportCriteria(ReportParamsConceptNames base);
}
