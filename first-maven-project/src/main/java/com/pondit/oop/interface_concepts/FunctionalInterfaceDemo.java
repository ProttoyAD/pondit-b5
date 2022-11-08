package com.pondit.oop.interface_concepts;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {


//        InterfaceA a2 = () -> {
//            System.err.println("a2 in lambda");
//        };

//        a1.method1();
//        a2.method1();

//        InterfaceB b1 = new InterfaceB() {
//            @Override
//            public String test(String s) {
//                return s + " testing 1";
//            }
//        };

        InterfaceA a1 = b1 -> System.out.println(b1.test(2));

        InterfaceB b1 = new InterfaceB() {
            @Override
            public Integer test(Integer i) {
                return i + 10;
            }
        };

//        InterfaceB b2 = (Integer b) -> b + 30;

        a1.method1((Integer b) -> b + 30);

//        InterfaceB b2 = (String s) -> s + " testing 2";

//        System.out.println(b1.test("Hello world"));
//        System.err.println(b2.test("Hello world"));
    }
}


interface InterfaceA {
    void method1(InterfaceB b);
}

@FunctionalInterface
interface InterfaceB {
    Integer test(Integer i);
}