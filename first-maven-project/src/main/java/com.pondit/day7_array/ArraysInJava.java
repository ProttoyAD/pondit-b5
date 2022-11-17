package com.pondit.day7_array;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class ArraysInJava {
    public static void main(String[] args) {
         int arr[] = new int[100_000_000];

         for (int i = 0; i < 100_000_000; i++) {
             arr[i] = i;
         }

        long forLoopCurrentTimeMillis = System.currentTimeMillis();
//        for (int i = 0; i< arr.length; i++) {
//            System.out.println(arr[i]);
//        }
        long forLoopEndingElapsedTime = System.currentTimeMillis() - forLoopCurrentTimeMillis;

        long spliteratorCurrentTimeMillis = System.currentTimeMillis();
//        Arrays.spliterator(arr).forEachRemaining((IntConsumer) integer -> {
//            System.out.println(integer);
//        });
        long spliteratorEndingElapsedTime = System.currentTimeMillis() - spliteratorCurrentTimeMillis;

        long parallelStreamStartTime = System.currentTimeMillis();
        Arrays.stream(arr).parallel().forEach(value -> System.out.println(value));
        long parallelStreamTotalTime = System.currentTimeMillis() - parallelStreamStartTime;

        System.out.println("Total time taken by for loop: " + (forLoopEndingElapsedTime / 1000));
        System.out.println("Total time taken by spliterator: " + (spliteratorEndingElapsedTime / 1000));
        System.out.println("Total time taken by parallel Stream: " + (parallelStreamTotalTime / 1000));
    }
}
