package com.pondit.collectionframeworks;

import java.util.ArrayList;
import java.util.List;

public class PlayingWithArrayList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("test3", "test1", "test2"));
        list.sort(String::compareTo);
        list.forEach(System.out::println);

//        Comparable
    }
}
