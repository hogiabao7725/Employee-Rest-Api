package com.hgb7725.employee_rest_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiException extends RuntimeException {

    private final String errorCode;
    private final HttpStatus status;

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.errorCode = String.valueOf(status.value());
        this.status = status;
    }

}
