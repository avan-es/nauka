package com.avanes.nauka.ApiError;

import com.avanes.nauka.employee.formats.DateFormat;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {

    private final HttpStatus status;

    private final String reason;

    private final String message;

    @DateTimeFormat(pattern = DateFormat.DATE_PATTERN)
    private final String timestamp;

    public ErrorResponse(HttpStatus status, String reason, String message, LocalDateTime timestamp) {
        this.status = status;
        this.message = message;
        this.reason = reason;
        this.timestamp = timestamp.format(DateFormat.DTF);
    }

}