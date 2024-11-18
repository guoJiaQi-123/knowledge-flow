package com.dataStructure.dataStructure.deque;

import java.util.Iterator;

public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {
    //哨兵节点
    Node<E> sentinel = new Node<>(null, null, null);
    //队列容量
    int capacity;
    //队列当前元素个数
    int size;

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    // a added b
    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        Node<E> added = new Node<>(a, value, b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    // a added b
    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> a = sentinel.prev;
        Node<E> b = sentinel;
        Node<E> added = new Node<>(a, value, b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    // a removed b
    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> a = sentinel;
        Node<E> removed = a.next;
        Node<E> b = removed.next;
        a.next=b;
        b.prev=a;
        size--;
        return removed.value;
    }

    // a removed b
    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        Node<E> a =sentinel.prev.prev;
        Node<E> removed = sentinel.prev;
        Node<E> b = sentinel;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
