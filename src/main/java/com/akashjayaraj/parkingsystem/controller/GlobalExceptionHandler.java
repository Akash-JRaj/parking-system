package com.akashjayaraj.parkingsystem.controller;

import com.akashjayaraj.parkingsystem.exception.InvalidAadhaarException;
import com.akashjayaraj.parkingsystem.exception.UserNotFoundException;
import com.akashjayaraj.parkingsystem.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidAadhaarException.class)
    public ResponseEntity<String> handleInvalidAadhaarException(InvalidAadhaarException exception) {
        return ResponseEntity.status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS).body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
