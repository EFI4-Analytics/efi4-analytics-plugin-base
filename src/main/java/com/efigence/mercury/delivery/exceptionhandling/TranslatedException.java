package com.efigence.mercury.delivery.exceptionhandling;

public class TranslatedException {

    private String message;
    private Exception exception;

    static TranslatedException full(Exception ex) {
        TranslatedException tex = new TranslatedException();
        tex.message = ex.getMessage();
        tex.exception = ex;
        return tex;
    }

    static TranslatedException onlyMessage(Exception ex) {
        TranslatedException tex = new TranslatedException();
        tex.message = ex.getMessage();
        return tex;
    }

    public String getMessage() {
        return message;
    }

    public Exception getException() {
        return exception;
    }
}
