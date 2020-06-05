package com.efigence.mercury.model.user.exception;

import java.util.UUID;

import static java.lang.String.format;

public class NoAccessException extends RuntimeException {

    public NoAccessException(UUID watUserId) {
        super(format("User with ID %s has no access", watUserId));
    }

    public NoAccessException(UUID watUserId, String resource) {
        super(format("User with ID %s has no access to %s", watUserId, resource));
    }

}
