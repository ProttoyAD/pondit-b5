package com.pondit.oop.polymorphism;

public class MethodOverloadingExample {
    public void print(String value) {
        System.out.println(value);
    }

    public void print (int x) {
        System.out.println(x);
    }

    public void print(int x, int y) {
        System.out.println(x + y);
    }

    public void print(Object o) {
        System.out.println(o);
    }

    public static void main(String[] args) {
        MethodOverloadingExample test = new MethodOverloadingExample();
        test.print("iurfiurb");
        test.print(12);
        test.print(1, 2);
        test.print(12.33);
    }
}

