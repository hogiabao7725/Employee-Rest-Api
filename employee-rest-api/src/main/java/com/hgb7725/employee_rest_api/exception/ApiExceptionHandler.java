package com.hgb7725.employee_rest_api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiExceptionResponse> handleApiException(ApiException exception) {
        ApiExceptionResponse response = new ApiExceptionResponse(
                exception.getMessage(),
                exception.getErrorCode(),
                exception.getStatus(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(response, exception.getStatus());
    }

}
