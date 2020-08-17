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

//1. General method to catch all the exception. Return String with Stack Trace.
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> catchGeneralException(Exception ex, WebRequest request){
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

//2. Method to catch specific Exception. ie. NullPointer, ArrayIndexOutOfBound.
// I am providing Custome Error message using By creating Custom Error message class and return object of this class.
    @ExceptionHandler(value={NullPointerException.class})
    public ResponseEntity<Object> catchNullPointerException(NullPointerException ex, WebRequest request){

       return new ResponseEntity<>(new CustomErrorMessage(new Date(),"Null pointer Exception"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//3. Catch Custom Exception. User throw a custom exception in the method and Catch that exception.

    @ExceptionHandler(value = {ThrowCustomException.class} )
    public ResponseEntity<Object> catchCustomThrownException(ThrowCustomException exception, WebRequest request){

        return new ResponseEntity<>(exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

