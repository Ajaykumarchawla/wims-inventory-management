package com.ajayk.wims.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleItemNotFoundException(ItemNotFoundException e) {
        Map<String,String> response = new HashMap<>();
        response.put("message",e.getMessage());
        response.put("timestamp", LocalDateTime.now().toString());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> handleItemAlreadyExistsException(ItemAlreadyExistsException e) {
        Map<String,String> response = new HashMap<>();
        response.put("message",e.getMessage());
        response.put("timestamp", LocalDateTime.now().toString());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String,String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(),error.getDefaultMessage()));

        errors.put("timestamp", LocalDateTime.now().toString());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,String>> handleException(Exception e) {
        Map<String,String> errors = new HashMap<>();
        errors.put("message",e.getMessage());
        errors.put("timestamp", LocalDateTime.now().toString());
        return new ResponseEntity<>(errors,HttpStatus.INTERNAL_SERVER_ERROR);

    }



}
