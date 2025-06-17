package com.nicoarbio.cardealership.branchservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerAdvice {

    public static final String TIMESTAMP = "timestamp";
    public static final String STATUS = "status";
    public static final String ERROR = "error";
    public static final String MESSAGE = "message";
    public static final String MESSAGES = "messages";

    /**
     * Handles validation errors for method arguments in controller.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> body = Map.of(
                TIMESTAMP, LocalDateTime.now(),
                STATUS, 400,
                ERROR, "Validation Failed",
                MESSAGES, ex.getBindingResult().getFieldErrors().stream()
                        .map(err -> Map.of("field", err.getField(), "message", err.getDefaultMessage()))
                        .toList()
        );
        return ResponseEntity.badRequest().body(body);
    }

    /**
     * Handles specific exceptions for not found resources.
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                TIMESTAMP, LocalDateTime.now(),
                STATUS, 404,
                ERROR, "Not Found",
                MESSAGE, ex.getMessage()
        ));
    }

    /**
     * Handles generic exceptions that are not caught by other handlers.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                TIMESTAMP, LocalDateTime.now(),
                STATUS, 500,
                ERROR, "Internal Server Error",
                MESSAGE, ex.getMessage()
        ));
    }

}

