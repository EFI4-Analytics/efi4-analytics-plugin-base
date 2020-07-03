package com.efigence.mercury.usecase.contract.common;

public interface ValidationResultSupplier {
    <T> ValidationResult<T> get(Object target, String objectName, T ctx);
}
