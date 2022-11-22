package com.pondit.collection_frameworks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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

        // Example of forEach method to iterate over the collection
        items.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // Example of forEach method in one line
        items.forEach(System.out::println);
    }
}
