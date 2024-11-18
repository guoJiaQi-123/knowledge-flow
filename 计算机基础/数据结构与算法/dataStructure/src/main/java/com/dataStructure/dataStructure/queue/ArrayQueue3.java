package com.dataStructure.dataStructure.queue;

import java.util.Iterator;

/**
 * 仅用 head, tail 判断空满, head, tail 需要换算成索引值
 *
 * @param <E> 队列中元素类型
 */
public class ArrayQueue3<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue3(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[(int) (Integer.toUnsignedLong(tail) % array.length)] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[(int) (Integer.toUnsignedLong(head)  % array.length)];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E value = array[(int) (Integer.toUnsignedLong(head) % array.length)];
        return value;
    }

    @Override
    public boolean isEmpty() {
        return tail == head;
    }

    @Override
    public boolean isFull() {
        return (tail - head) == array.length;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = array[(int) (Integer.toUnsignedLong(p) % array.length)];
                p++;
                return value;
            }
        };
    }
}
