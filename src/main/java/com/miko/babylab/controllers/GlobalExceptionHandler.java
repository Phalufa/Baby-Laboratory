package com.miko.babylab.controllers;

import com.miko.babylab.services.exceptions.BabyAlreadyExistsException;
import com.miko.babylab.services.exceptions.BabyDoesntExistsException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler
 * @author Gal
 */
@RestControllerAdvice
@CrossOrigin(value = {"http://localhost:4200"})
public class GlobalExceptionHandler {

    @ExceptionHandler(BabyAlreadyExistsException.class)
    private ResponseEntity<?> alreadyExistsError(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(BabyDoesntExistsException.class)
    private ResponseEntity<?> doesntExistsError(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    private ResponseEntity<?> serverError(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");
    }
}
