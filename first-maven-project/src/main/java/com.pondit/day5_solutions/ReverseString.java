package com.pondit.day5_solutions;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";

        var arr = s.split(" ");

//        Arrays.stream(arr).forEach(str -> {
//            StringBuilder sb = new StringBuilder(s);
//            System.out.println(sb.reverse());
//        });

//        Arrays.stream(arr).forEach(str -> {
//            for (int i = str.length() - 1; i >= 0; i--) {
//                System.out.print(str.charAt(i));
//            }
//            System.out.println();
//        });

        for (var j = 0; j < arr.length; j++ ) {
            for (int i = arr[j].length() - 1; i >= 0; i--) {
                System.out.print(arr[j].charAt(i));
            }
            System.out.println();
        }

//            for (int i = s.length() - 1; i >= 0; i--) {
//                System.out.print(s.charAt(i));
//            }
//            System.out.println();
//        for (var str : arr) {
//            for (int i = str.length() - 1; i >= 0; i--) {
//                System.out.print(str.charAt(i));
//            }
//            System.out.println();
//        }
    }
}
