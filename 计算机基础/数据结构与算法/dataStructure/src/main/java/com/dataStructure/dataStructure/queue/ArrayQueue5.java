package com.dataStructure.dataStructure.queue;

import java.util.Iterator;

//解决如果传入的容量参数如果不是2的n次方
//1.报异常
//2.修改容量为大于他的最小2的n次方     -->  相当于如果用户传入的参数不是2的n次方，则自动扩容至大于参数的最小2的n次方

/**
 * 仅用 head, tail 判断空满, head, tail 需要换算成索引值
 *
 * @param <E> 队列中元素类型
 */
public class ArrayQueue5<E> implements Queue<E>, Iterable<E> {
    private final E[] array;
    int head = 0;
    int tail = 0;

    @SuppressWarnings("all")
    public ArrayQueue5(int capacity) {
        /*//抛异常
        if ((capacity & capacity - 1) != 0) {
            throw new IllegalArgumentException("请传入容量为2的N次方的容量参数");
        }*/

        //增大容量为大于当前参数的最小2的n次方    13 -> 16   22 -> 32
        if ((capacity & capacity - 1) != 0) {
            int n = (int) ((Math.log10(capacity) / Math.log10(2)) + 1);//计算大于参数的最小2的n次方的n
            capacity = 1 << n;  //左移运算符，相当于乘2 ， 1 << n相当于 2^n
            System.out.println(capacity);
        }
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
