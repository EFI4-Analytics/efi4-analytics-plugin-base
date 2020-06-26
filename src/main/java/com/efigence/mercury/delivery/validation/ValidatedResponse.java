package com.efigence.mercury.delivery.validation;

import com.efigence.mercury.usecase.contract.common.Error;

import java.util.List;

public class ValidatedResponse<T> {
    private final T returnedObject;
    private final List<Error> errors;

    public ValidatedResponse(T returnedObject, List<Error> errors) {
        this.returnedObject = returnedObject;
        this.errors = errors;
    }

    public T getReturnedObject() {
        return returnedObject;
    }

    public List<Error> getErrors() {
        return errors;
    }
}
