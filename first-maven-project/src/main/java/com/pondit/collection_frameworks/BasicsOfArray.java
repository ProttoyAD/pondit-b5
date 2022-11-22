package com.pondit.collection_frameworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BasicsOfArray {

    public static void main(String[] args) {

        int arr[] = new int[Integer.MAX_VALUE/2];
        for (int i = 0; i <Integer.MAX_VALUE/2; i++) {
            arr[i] = i;
        }
    }
}
