package com.avanes.nauka.ApiError.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String error) {
        super(error);
    }

}
