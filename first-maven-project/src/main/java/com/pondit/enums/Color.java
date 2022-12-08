package com.pondit.enums;

import java.util.Arrays;

public enum Color {
    RED("#FF0000"),
    GREEN("#00FF00"),
    BLUE("#0000FF");

    private String value;

    Color (String hexa) {
        this.value = hexa;
    }

    public static String getValue(Color color) {
        String value1 = color.value;
        return value1;
    }
}

class TestColor {
    public static void main(String[] args) {
        System.out.println(Color.getValue(Color.RED));
    }
}