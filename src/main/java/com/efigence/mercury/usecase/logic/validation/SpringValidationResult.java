package com.efigence.mercury.usecase.logic.validation;

import com.efigence.mercury.usecase.contract.common.Error;
import com.efigence.mercury.usecase.contract.common.ValidationResult;
import lombok.Getter;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class SpringValidationResult<C> implements ValidationResult<C> {

    private final Errors errors;
    @Getter private final C context;

    SpringValidationResult(Object target, String name, C context) {
        this.context = context;
        this.errors = new BeanPropertyBindingResult(target, name);
    }

    @Override
    public boolean hasErrors() {
        return errors.hasErrors();
    }

    @Override
    public void rejectValue(String field, String errorCode, Object... errorArgs) {
        errors.rejectValue(field, errorCode, errorArgs, null);
    }

    @Override
    public void rejectValue(String field, String errorCode) {
        errors.rejectValue(field, errorCode);
    }

    @Override
    public void reject(String errorCode, Object... errorArgs) {
        errors.reject(errorCode, errorArgs, null);
    }

    @Override
    public void reject(String errorCode) {
        errors.reject(errorCode);
    }

    @Override
    public void pushNestedPath(String subPath) {
        errors.pushNestedPath(subPath);
    }

    @Override
    public void popNestedPath() {
        errors.popNestedPath();
    }

    @Override
    public boolean hasFieldErrors(String field) {
        return errors.hasFieldErrors(field);
    }

    @Override
    public List<Error> getErrors() {
        return Stream.concat(
                errors.getFieldErrors().stream()
                        .map(SpringValidationResult::convertFieldError),
                errors.getGlobalErrors().stream()
                        .map(SpringValidationResult::convertObjectError))
                .collect(Collectors.toList());
    }

    private static Error convertFieldError(FieldError fieldError) {
        return Error.builder()
                .arguments(convertToString(fieldError.getArguments()))
                .codes(asList(fieldError.getCodes()))
                .rejectedValue(fieldError.getRejectedValue())
                .rejectedField(fieldError.getField())
                .build();
    }

    private static Error convertObjectError(ObjectError objectError) {
        return Error.builder()
                .arguments(convertToString(objectError.getArguments()))
                .codes(asList(objectError.getCodes()))
                .build();
    }

    private static List<String> convertToString(Object[] objects) {
        if (objects == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(objects)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
