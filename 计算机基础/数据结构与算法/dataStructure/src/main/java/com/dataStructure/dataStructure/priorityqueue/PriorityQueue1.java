package com.dataStructure.dataStructure.priorityqueue;

import com.dataStructure.dataStructure.queue.Queue;

/**
 * 基于<b>无序数组</b>实现
 *
 * @param <E> 队列中元素类型, 必须实现 Priority 接口
 */
@SuppressWarnings("all")
public class PriorityQueue1<E extends Priority> implements Queue<E> {

    Priority[] array;
    private int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        array[size++] = value;
        return true;
    }

    @Override
    public E poll() {

        if (isEmpty()) {
            return null;
        }
        int max = selectMax(array);
        Priority priority = array[max];
        remove(max);
        return (E) priority;
    }

    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
        }
        array[--size] = null;// help GC
    }


    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax(array);
        return (E) array[max];
    }

    // 返回优先级最高的索引值
    private int selectMax(Priority[] array) {
        int max = 0;
        for (int i = 1; i < size; i++) {
            if (array[i].priority() > array[max].priority()) {
                max = i;
            }
        }
        return max;
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
