package com.pondit.oop.interface_concepts;

interface A {
    default void print() {
        System.out.println("Print from A");
    }
}

interface B {
    default void print() {
        System.out.println("Print from B");
    }
}

//interface D extends A, B {
//
//}

class C implements A, B {

    @Override
    public void print() {
        A.super.print();
    }
}
public class TestMultipleInterfacesWithSameMethod {
    public static void main(String[] args) {
        B obj = new C();
        obj.print();
    }
}
