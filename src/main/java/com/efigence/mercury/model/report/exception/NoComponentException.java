package com.efigence.mercury.model.report.exception;

import static java.lang.String.format;

public class NoComponentException extends RuntimeException {

    public NoComponentException(String componentConceptName) {
        super(format("There is no component with concept name: %s", componentConceptName));
    }
}
