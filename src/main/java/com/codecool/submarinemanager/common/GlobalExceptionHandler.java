package com.codecool.submarinemanager.common;

import com.codecool.submarinemanager.exception.IdDoesNotExistException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

   @ExceptionHandler(ConstraintViolationException.class)
   public ResponseEntity<String> handleConstraintViolationException() {
       return new ResponseEntity("database constrains failed", HttpStatus.INTERNAL_SERVER_ERROR);
   }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException() {
        return new ResponseEntity("database integrity failed", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdDoesNotExistException.class)
    public ResponseEntity<String> handleIdDoesNotExistException() {
        return new ResponseEntity("id doesn't exist", HttpStatus.BAD_REQUEST);
    }
}