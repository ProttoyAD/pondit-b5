package com.pondit.collectionframeworks.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {


//        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("prottoy", 24);
        map.put("bristy", 23);
        map.put("raihan", 26);
        map.put("tarek", 24);

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
