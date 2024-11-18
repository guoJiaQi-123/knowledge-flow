package com.dataStructure.dataStructure.priorityqueue;

import com.dataStructure.dataStructure.queue.Queue;

/**
 * 基于<b>有序数组</b>实现
 *
 * @param <E> 队列中元素类型, 必须实现 Priority 接口
 */
@SuppressWarnings("all")
public class PriorityQueue2<E extends Priority> implements Queue<E> {

    Priority[] array;
    private int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }


    /*


        0   1   2   3   4   5
        1   5   8   9   10  21



    * */
    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        insert(value);
        size++;
        return true;
    }

    private void insert(E value) {
        int i = size - 1;
        while (i >= 0 && array[i].priority() > value.priority()) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = (E) array[size - 1];
        array[--size] = null; //help GC
        return value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }
}
