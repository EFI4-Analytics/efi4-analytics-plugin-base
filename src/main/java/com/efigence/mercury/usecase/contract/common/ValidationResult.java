package com.efigence.mercury.usecase.contract.common;

import java.util.List;

public interface ValidationResult<C> {
    boolean hasErrors();
    List<Error> getErrors();
    void rejectValue(String field, String errorCode, Object... errorArgs);
    void rejectValue(String field, String errorCode);
    void reject(String errorCode, Object... errorArgs);
    void reject(String errorCode);
    void pushNestedPath(String subPath);
    void popNestedPath();
    boolean hasFieldErrors(String field);
    C getContext();
}
