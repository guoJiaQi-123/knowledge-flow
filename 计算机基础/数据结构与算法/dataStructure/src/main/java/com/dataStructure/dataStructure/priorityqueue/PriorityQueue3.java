package com.dataStructure.dataStructure.priorityqueue;

import com.dataStructure.dataStructure.queue.Queue;

/**
 * 基于<b>大顶堆</b>实现
 *
 * @param <E> 队列中元素类型, 必须实现 Priority 接口
 */
@SuppressWarnings("all")
public class PriorityQueue3<E extends Priority> implements Queue<E> {
    Priority[] array;
    int size;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }


    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int father = (child - 1) / 2;
        while (child > 0 && value.priority() > array[father].priority()) {
            array[child] = array[father];
            child = father;
            father = (child - 1) / 2;
        }
        array[child] = value;
        return true;
    }


    /*
        1. 交换堆顶和尾部元素, 让尾部元素出队
        2. (下潜)
            - 从堆顶开始, 将父元素与两个孩子较大者交换
            - 直到父元素大于两个孩子, 或没有孩子为止
    */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        //1.交换堆顶元素与最后一个元素，删除最后一个元素
        swap(0, size - 1);
        size--;
        Priority e = array[size];
        array[size] = null;// help GC
        //2.将推顶元素与其孩子不断比较，到他合适位置
        down(0);
        return (E) e;
    }

    private void down(int father) {
        int left = father * 2 + 1;
        int right = left + 1;
        int max = father;// 假设父元素优先级最高
        if (left < size && array[left].priority() > array[max].priority()) {
            max = left;
        }
        if (right < size && array[right].priority() > array[max].priority()) {
            max = right;
        }
        if (max != father) {// 说明发生了交换，则有孩子比父亲大
            swap(max, father);
            down(max);
        }
    }

    private void swap(int i, int j) {
        Priority t = array[j];
        array[j] = array[i];
        array[i] = t;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
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
