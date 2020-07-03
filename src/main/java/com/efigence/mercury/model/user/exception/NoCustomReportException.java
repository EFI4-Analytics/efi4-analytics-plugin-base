package com.efigence.mercury.model.user.exception;

import java.util.UUID;

import static java.lang.String.format;

public class NoCustomReportException extends RuntimeException {

    public NoCustomReportException(UUID reportId) {
        super(format("Report with ID %s does not exist", reportId));
    }
}
