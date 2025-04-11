package com.hgb7725.employee_rest_api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ApiExceptionResponse {

    private String message;
    private String errorCode;
    private HttpStatus status;
    private LocalDateTime timestamp;

}
