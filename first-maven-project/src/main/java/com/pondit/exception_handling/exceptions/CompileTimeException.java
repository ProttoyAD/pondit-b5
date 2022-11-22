package com.pondit.exception_handling.exceptions;

public class CompileTimeException extends Exception {
    private String message;
    CompileTimeException (String message) {
        super(message);
        this.message = message;
    }
}
