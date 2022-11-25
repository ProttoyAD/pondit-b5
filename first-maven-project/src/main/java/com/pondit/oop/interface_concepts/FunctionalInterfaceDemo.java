package com.pondit.oop.interface_concepts;

public class FunctionalInterfaceDemo {

    InterfaceB b1 = new InterfaceB() {
        @Override
        public Integer test(Integer i, Integer j) {
            return i + 10;
        }
    };

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

        InterfaceA a1 = b1 -> System.out.println(b1.test(2, 3));

        InterfaceB b1 = new InterfaceB() {
            @Override
            public Integer test(Integer i, Integer j) {
                return i + 10;
            }
        };

        System.out.println(new InterfaceB() {
            @Override
            public Integer test(Integer i, Integer j) {
                return i + 10;
            }
        }.test(10, 20));
//        InterfaceB b2 = (Integer b) -> b + 30;

        a1.method1((Integer b, Integer c) -> b + 30);

//        InterfaceB b2 = (String s) -> s + " testing 2";

//        System.out.println(b1.test("Hello world"));
//        System.err.println(b2.test("Hello world"));


        // Approach 1
        InterfaceB b2 = new InterfaceB() {
            @Override
            public Integer test(Integer i, Integer j) {
                return FunctionalInterfaceDemo.print(i, j);
            }
        };
        b2.test(25, 35);

        // Approach 2 (short form of Approach 1)
        InterfaceB b3 = (i, j) ->  FunctionalInterfaceDemo.print(i, j);
        b3.test(5, 10);

        // Approach 3 (short form of Approach 2)
        InterfaceB b4 = FunctionalInterfaceDemo::print;
        b4.test(2, 3);
    }

    public static int print (int i, int j) {
        System.out.println(i + j);
        return i + j;
    }
}

@FunctionalInterface
interface InterfaceB {
    Integer test(Integer i, Integer j);
}
interface InterfaceA {
    void method1(InterfaceB b);
}