package com.gmail.robertosrjr.reactiveservice.application.exception;

public class TaxiFareException extends RuntimeException {

    public TaxiFareException() { }

    public TaxiFareException(String message) {
        super(message);
    }

    public TaxiFareException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaxiFareException(Throwable cause) {
        super(cause);
    }

    protected TaxiFareException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
