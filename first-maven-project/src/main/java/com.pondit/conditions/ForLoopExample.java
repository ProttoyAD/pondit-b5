package com.pondit.conditions;

public class ForLoopExample {

    public static void main(String[] args) {
        int i = 0;

/*        for(; i< 5;) {
            System.out.println("Now at lap: " + i);
            i++;
        }*/

        while (i< 5) {
            System.out.println("Now at lap: " + i);
            i++;
        }

        do {
            System.out.println("Now at lap: " + i);
            i++;
        } while (i < 5);
    }
}
