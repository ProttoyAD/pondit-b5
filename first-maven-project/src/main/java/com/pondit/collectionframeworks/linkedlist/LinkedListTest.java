package com.pondit.collectionframeworks.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);
//        list.

        System.out.println(list.get(3));


        com.pondit.collectionframeworks.linkedlist.LinkedList<Integer> ll = new com.pondit.collectionframeworks.linkedlist.LinkedList<>();
        ll.add(2);
        ll.add(3);
        ll.add(2);
        ll.add(4);
        ll.add(5);

        System.out.println(ll.size());

        System.out.println(ll.get(4));

        System.out.println(ll.contains(4));
        System.out.println(ll.contains(5));
        System.out.println(ll.contains(6));
    }
}
