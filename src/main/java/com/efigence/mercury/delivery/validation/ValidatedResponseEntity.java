package com.efigence.mercury.delivery.validation;

import com.efigence.mercury.usecase.contract.common.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ValidatedResponseEntity<T> extends ResponseEntity<ValidatedResponse<T>> {

    ValidatedResponseEntity(T returnedObject, List<Error> errors, HttpStatus status) {
        super(new ValidatedResponse<>(returnedObject, errors), status);
    }
}
