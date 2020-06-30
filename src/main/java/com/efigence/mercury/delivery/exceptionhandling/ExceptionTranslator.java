package com.efigence.mercury.delivery.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface ExceptionTranslator {
    ResponseEntity<TranslatedException> translate(Exception ex, HttpStatus status);
}
