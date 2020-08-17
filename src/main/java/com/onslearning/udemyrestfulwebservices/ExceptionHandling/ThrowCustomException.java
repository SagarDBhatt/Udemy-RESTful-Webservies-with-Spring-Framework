package com.onslearning.udemyrestfulwebservices.ExceptionHandling;

public class ThrowCustomException extends RuntimeException{

    public ThrowCustomException(String errorMessage){
        super(errorMessage);
    }
}
