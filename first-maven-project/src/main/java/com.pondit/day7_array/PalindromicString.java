package com.pondit.day7_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromicString {

    private boolean checkPalindrome(String line) {
        for (int i = 0, j = line.length() - 1; i < j; i++, j --) {
            if (line.charAt(i) != line.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        PalindromicString palindromicString = new PalindromicString();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
//        while ((line = br.readLine()) != null) {
//            System.out.println(palindromicString.checkPalindrome(line));
//        }

        int i = 5;
        System.out.println(i++);
        System.out.println(i + i++);
        System.out.println(i--);
        System.out.println(i - i--);
        System.out.println("========================================");
        i = 5;
        System.out.println(i++
                +
                i++
        );// 5 + (5 + 1)

        // 6 + 1
        System.out.println(i); // 6+1 = 7
        System.out.println(i-- // 7 - 6 = 1
                -
                i--);
        System.out.println(i); // 6-1 = 5

//        System.out.println(i+=100); // i = i + 100
//        System.out.println(i = i + 2);
    }


}
