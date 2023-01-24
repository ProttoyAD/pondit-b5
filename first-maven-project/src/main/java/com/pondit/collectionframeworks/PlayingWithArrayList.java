package com.pondit.collectionframeworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class PlayingWithArrayList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("test3", "test1", "test2"));
        list.sort(String::compareTo);
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        list.forEach(s -> {
            System.out.println(s);
        });

        list.forEach(s -> System.out.println(s));

        list.forEach(System.out::println);
//        Comparable
    }
}
