package com.efigence.mercury.model.report.exception;

import static java.lang.String.format;

public class NoSegmentException extends RuntimeException {

    public NoSegmentException(Object segmentId) {
        super(format("There is no segment with segmentId: %s", segmentId));
    }

}
