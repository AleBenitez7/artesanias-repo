package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ArtesaniaExceptionController {
    @ExceptionHandler(value= ArtesaniaNotfoundException.class)
    public ResponseEntity<Object>exception(ArtesaniaNotfoundException exception){
        return new ResponseEntity<>("Artesania does not exists for this id", HttpStatus.NOT_FOUND);
    }
}
