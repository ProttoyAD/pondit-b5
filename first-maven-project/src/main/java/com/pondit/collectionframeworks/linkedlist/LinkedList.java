package com.pondit.collectionframeworks.linkedlist;

public class LinkedList<T> {
    private int idx = 0;
    private Node<T> node;

    public T get(int idx) {
        Node<T> next = this.node;
        int i = 0;
        while (next != null) {
            if (i == idx) {
                return next.getData();
            }
            i++;
            next = next.next;
        }
        return null;
    }

    public void add (T data) {
        Node<T> next = new Node();
        if (this.node == null) {
            this.node = new Node<T>();
            this.node.data = data;
            idx++;
        } else {
            next = this.node;
            while (next.hasNext()) {
                next = next.next;
            }
            next.setNext(new Node<T>());
            next.next.data = data;
            idx++;
        }
    }

    public int size () {
        return this.idx;
    }

    public boolean contains(T obj) {
        if (this.node != null && obj.equals(this.node.data)) {
            return true;
        } else if (this.node.hasNext()) {
            Node<T> next = node.next;
            while (next != null) {
                if (obj.equals(next.data)) {
                    return true;
                }
                next = next.next;
            }
        }
        return false;
    }
    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return this.getNext() != null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
