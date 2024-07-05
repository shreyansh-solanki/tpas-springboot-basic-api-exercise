package com.tpas.book.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();

        Map<String, String> response = new HashMap<>();

        response.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
        response.put("error", message);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
