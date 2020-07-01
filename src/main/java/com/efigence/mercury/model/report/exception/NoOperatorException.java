package com.efigence.mercury.model.report.exception;

import static java.lang.String.format;

public class NoOperatorException extends RuntimeException {

    public NoOperatorException(String componentConceptName) {
        super(format("There is no operator with concept name: %s", componentConceptName));
    }
}
