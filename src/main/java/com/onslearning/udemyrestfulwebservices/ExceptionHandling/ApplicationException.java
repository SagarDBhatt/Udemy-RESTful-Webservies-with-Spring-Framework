package com.onslearning.udemyrestfulwebservices.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value={NullPointerException.class})
    public ResponseEntity<Object> catchNullPointerException(NullPointerException ex, WebRequest request){
       return new ResponseEntity<>(new CustomErrorMessage(new Date(),"Null pointer Exception"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
