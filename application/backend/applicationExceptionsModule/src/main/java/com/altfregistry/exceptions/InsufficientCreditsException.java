package com.altfregistry.exceptions;

public class InsufficientCreditsException extends Exception{
    public InsufficientCreditsException() {
    }

    public InsufficientCreditsException(String message) {
        super(message);
    }

    public InsufficientCreditsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientCreditsException(Throwable cause) {
        super(cause);
    }

    public InsufficientCreditsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
