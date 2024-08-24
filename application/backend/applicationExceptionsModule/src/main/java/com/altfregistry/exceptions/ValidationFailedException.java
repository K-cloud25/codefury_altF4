package com.altfregistry.exceptions;

public class ValidationFailedException extends ApplicationExceptions{

    public ValidationFailedException() {
    }

    public ValidationFailedException(String message) {
        super(message);
    }

    public ValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationFailedException(Throwable cause) {
        super(cause);
    }

    public ValidationFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
