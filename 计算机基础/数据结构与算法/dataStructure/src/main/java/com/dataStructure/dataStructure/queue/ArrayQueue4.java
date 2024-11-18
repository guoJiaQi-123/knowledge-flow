package com.dataStructure.dataStructure.queue;

import java.util.Iterator;

//用到位运算。要求队列容量必须是 2 的整数次
/**
 * 仅用 head, tail 判断空满, head, tail 需要换算成索引值
 *
 * @param <E> 队列中元素类型
 */
public class ArrayQueue4<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue4(int capacity) {
        array = (E[]) new Object[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        //使用位运算，规律：当一个数对2的整数次的数取模时，余数=这个数 &（按位与） 2的整数次-1
        //   666 % 8 = 666 & 7

        /*
        求模运算：
        - 如果除数是 2 的 n 次方
        - 那么被除数的后 n 位即为余数 (模)
        - 求被除数的后 n 位方法： 与 2^n-1 按位 与
        */
        array[tail & array.length - 1] = value;
        tail++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head & array.length - 1];
        head++;
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        E value = array[head & array.length - 1];
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
                E value = array[p & array.length - 1];
                p++;
                return value;
            }
        };
    }
}
