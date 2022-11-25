package com.pondit.collection_frameworks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CommonMethodsOfCollectionInterface {

    public static void main(String[] args) {
        // retainAll() example
        List<String> items = new ArrayList<>();
        items.addAll(List.of("Hello", "Hi", "new", "old", "deprecated"));
        items.retainAll(List.of("Hi", "old"));

        // Example of iterator method to iterate over the collection
        var itr = items.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Example of for-each loop
        for (String item: items) {
            System.out.println(item);
        }

        // Example of forEach method to iterate over the collection (implementation#1)
        items.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // Shorter form of implementation#1 (implementation#2)
        items.forEach((s) -> {
            System.out.println(s);
        });

        // Shorter form of implementation#2 (implementation#3)
        items.forEach(s -> System.out.println(s));

        // Shorter form of implementation#3 (implementation#4)
        items.forEach(System.out::println);
    }
}
