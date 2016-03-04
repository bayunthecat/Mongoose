package com.lwd.core.parser.exception;

public class ClassDoesNotExistException extends RuntimeException {

    public ClassDoesNotExistException() {
    }

    public ClassDoesNotExistException(String message) {
        super(message);
    }

    public ClassDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
