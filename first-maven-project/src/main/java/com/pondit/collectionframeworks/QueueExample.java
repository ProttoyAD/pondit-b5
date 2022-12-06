package com.pondit.collectionframeworks;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("uwfoief");
        queue.add("uwforfer");
        queue.add("uwfowrji");

        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println("====================");
        queue.forEach(System.out::println);
        System.out.println("====================");
        System.out.println(queue.element());
        queue.offer("hello");
        System.out.println("=====================");
        queue.forEach(System.out::println);
    }

}
