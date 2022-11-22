package com.pondit.exception_handling.exceptions;


import java.io.IOException;

public class ExceptionTest {
    public static void main(String[] args) {
        ExceptionTest et = new ExceptionTest();
//        et.sendMessage("null");
    }
    void sendMessage(String messageBody) throws IOException {
        if (messageBody == null) {
            throw new NullPointerException("No message available");
        }
    }
}
