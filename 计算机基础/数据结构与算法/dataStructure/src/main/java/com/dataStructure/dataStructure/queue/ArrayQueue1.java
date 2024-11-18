package com.dataStructure.dataStructure.queue;

import java.util.Iterator;

/**
 * 仅用 head, tail 判断空满, head, tail 即为索引值, tail 停下来的位置不存储元素
 *
 * @param <E> 队列中元素类型
 */
public class ArrayQueue1<E> implements Queue<E>, Iterable<E> {
    private final E[] array;//初始化数组
    private int head = 0;   //头结点
    private int tail = 0;   //尾节点
    private final int length;//数组长度

    @SuppressWarnings("all")
    public ArrayQueue1(int capacity) {
        length = capacity+1;
        array = (E[]) new Object[capacity + 1];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % length;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head];
        head = (head + 1) % length;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % length == head;
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
                E value = array[p];
                p = (p + 1) % length;
                return value;
            }
        };
    }
}
