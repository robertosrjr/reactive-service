package com.gmail.robertosrjr.reactiveservice.framework.exception;

import com.gmail.robertosrjr.reactiveservice.application.exception.TaxiFareException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  // 409
    @ExceptionHandler(TaxiFareException.class)
    public ResponseEntity<String> handleInternalServerError() {

        return new ResponseEntity("cagadinhaaaa", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
