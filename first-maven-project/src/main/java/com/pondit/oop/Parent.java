package com.pondit.oop;

public class Parent {
    public int a = 10;
    private int b = 20;
    protected int c = 30;
    int d = 40;

    public void printA() {
        System.out.println(a);
    }

    public void printB() {
        System.out.println(this.b);
    }

    public void printC() {
        System.out.println(this.c);
    }

    public void printD() {
        System.out.println(this.d);
    }

    public void print() {}
}
