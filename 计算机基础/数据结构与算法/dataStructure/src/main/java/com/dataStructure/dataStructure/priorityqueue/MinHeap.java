package com.dataStructure.dataStructure.priorityqueue;

import com.dataStructure.dataStructure.LinkedList.ListNode;

/**
 * 小顶堆
 */
public class MinHeap {
    ListNode[] array;
    int size;

    public MinHeap(int capacity) {
        array = new ListNode[capacity];
    }
    public boolean offer(ListNode value) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int father = (child - 1) / 2;
        while (child > 0 && value.val < array[father].val) {
            array[child] = array[father];
            child = father;
            father = (child - 1) / 2;
        }
        array[child] = value;
        return true;
    }
    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }

        //1.交换堆顶元素与最后一个元素，删除最后一个元素
        swap(0, size - 1);
        size--;
        ListNode e = array[size];
        array[size] = null;// help GC
        //2.将推顶元素与其孩子不断比较，到他合适位置
        down(0);
        return e;
    }

    private void down(int father) {
        int left = father * 2 + 1;
        int right = left + 1;
        int min = father;// 假设父元素最小
        if (left < size && array[left].val < array[min].val) {
            min = left;
        }
        if (right < size && array[right].val < array[min].val) {
            min = right;
        }
        if (min != father) {// 说明发生了交换，则有孩子比父亲大
            swap(min, father);
            down(min);
        }
    }

    private void swap(int i, int j) {
        ListNode t = array[j];
        array[j] = array[i];
        array[i] = t;
    }



    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
