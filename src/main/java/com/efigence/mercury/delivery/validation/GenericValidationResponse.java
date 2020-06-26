package com.efigence.mercury.delivery.validation;

import com.efigence.mercury.usecase.contract.common.Error;
import com.efigence.mercury.usecase.contract.common.ValidationResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

import static java.util.Collections.emptyList;

public abstract class GenericValidationResponse<T, R> implements ValidationResponse<T> {

    private HttpStatus status = HttpStatus.OK;
    private R returnedObject;
    private List<Error> errors;

    protected abstract R convertTo(T successObject);

    @Override
    public void onSuccess(T successObject) {
        onSuccess(convertTo(successObject), HttpStatus.OK);
    }

    @Override
    public void onError(List<Error> errors) {
        onError(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    protected void onSuccess(R returnedObject, HttpStatus httpStatus) {
        this.status = httpStatus;
        this.returnedObject = returnedObject;
        this.errors = null;
    }

    private void onError(List<Error> errors, HttpStatus httpStatus) {
        this.errors = errors;
        this.status = httpStatus;
        this.returnedObject = null;
    }

    public ValidatedResponseEntity<R> getResponse() {
        List<Error> errorList = errors != null ? errors : emptyList();
        return new ValidatedResponseEntity<>(returnedObject, errorList, status);
    }

}
