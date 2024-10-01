package org.kozhanov.decodergooglemap.exception;

public class UnsupportedParamsQuery extends RuntimeException {
    public UnsupportedParamsQuery(String message) {
        super(message);
    }

    public UnsupportedParamsQuery(String message, Throwable cause) {
        super(message, cause);
    }
}
