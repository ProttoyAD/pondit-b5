package com.pondit.conditions.day9_basic_algorithms;

public class RecursionAndStackTracing {


    public static void main(String[] args) {
        System.out.println("============= PRE INCREMENT ==============");

        recursiveAsLoop_preIncrement(0);

        System.out.println("============= POST INCREMENT ==============");
        recursiveAsLoop_postIncrement(0);
    }

    static void recursiveAsLoop_preIncrement(int i) {
//        if (i < 5) {
            i += 1;
            System.out.println(i);
            recursiveAsLoop_postIncrement(i);

            recursiveAsLoop_preIncrement(i);
//        }
    }

    static void recursiveAsLoop_postIncrement(int i) {
        if (i < 5) {
            System.out.println(i);
            i += 1;
            recursiveAsLoop_postIncrement(i);
        }
    }
}
