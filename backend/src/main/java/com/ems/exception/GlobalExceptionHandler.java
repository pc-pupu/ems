package com.ems.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ems.dto.ApiErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiErrorResponse> handleDuplicateEmail(DuplicateEmailException duplicateEmailException) {
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(), duplicateEmailException.getMessage(), LocalDateTime.now());
        System.out.print(apiErrorResponse);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiErrorResponse);
    }
}
