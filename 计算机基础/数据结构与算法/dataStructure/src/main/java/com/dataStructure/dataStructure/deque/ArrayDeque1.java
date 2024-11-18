package com.dataStructure.dataStructure.deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque1<E> implements Deque<E>, Iterable<E> {
    private E[] array;
    private int head;
    private int tail;

    @SuppressWarnings("all")
    public ArrayDeque1(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }

    //指针加一如果越界，则循环到队列头
    private int inc(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    //指针减一如果越界，则循环到队列尾
    private int dec(int i, int length) {
        if (i - 1 < 0) {
            return length - 1;
        }
        return i - 1;
    }

    /*

                t
            h
    0   1   2   3
    a   b       c
    offerFirst(a)
    offerFirst(b)

    offerLast(c)
     */
    @Override
    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        array[head] = value;
        head = inc(head, array.length);
        return true;
    }


    @Override
    public boolean offerLast(E value) {
        if (isFull()) {
            return false;
        }
        tail = dec(tail, array.length);
        array[tail] = value;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        head = dec(head, array.length);
        return array[head];
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        E value = array[tail];
        tail = inc(tail, array.length);
        return value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return array[dec(head, array.length)];
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return array[tail];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /*

                t
            h
    0   1   2   3
    a   b       c
    offerFirst(a)
    offerFirst(b)

    offerLast(c)
     */
    @Override
    public boolean isFull() {
        if (tail > head) {
            return tail - head == 1;
        } else if (head > tail) {
            return head - tail == array.length - 1;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = dec(head, array.length);

            @Override
            public boolean hasNext() {
                return p != tail - 1;
            }

            @Override
            public E next() {
                E value = array[p];
                p = dec(p, array.length);
                return value;
            }
        };
    }
}

