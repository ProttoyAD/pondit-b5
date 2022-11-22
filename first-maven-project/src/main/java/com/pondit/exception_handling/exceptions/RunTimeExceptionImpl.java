package com.pondit.exception_handling.exceptions;

public class RunTimeExceptionImpl extends RuntimeException{
    private String message;
    RunTimeExceptionImpl (String message) {
        super(message);
        this.message = message;
    }
}


