package com.pondit;

import java.util.Arrays;

public class HelloJava {
    public static void main(String[] args) {
        System.out.println("Hello Java");

        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" world");
        System.out.println(sb.toString());

        String str = "A quick cunning for jumped over a lazy dog"; //42 chars
        System.out.println(str.length());
        int i = 2;
        System.out.println(str.substring(i, i+5));
        System.out.println(str.substring(i));
        System.out.println(Arrays.toString(str.split(" ")));

        str = "My name is Syed Mainul Hasan. What is your name?";
        System.out.println(str.replaceAll("(name)", "urhiuer"));
        System.out.println(str.replaceFirst("(name)", "urhiuer"));
    }
}
