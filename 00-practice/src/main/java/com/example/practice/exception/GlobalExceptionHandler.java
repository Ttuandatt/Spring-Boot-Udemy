package com.example.practice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException exc) {
        ErrorCode errorCode = exc.getErrorCode();

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(errorCode.getCode());
        errorResponse.setMessage(errorCode.getMessage());
        errorResponse.setTimeStamp(new java.sql.Time(System.currentTimeMillis()));
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
