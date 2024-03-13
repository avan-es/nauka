package com.avanes.nauka.ApiError.exception;

public class ValidationException extends RuntimeException {
    public ValidationException(String error) {
        super(error);
    }

}