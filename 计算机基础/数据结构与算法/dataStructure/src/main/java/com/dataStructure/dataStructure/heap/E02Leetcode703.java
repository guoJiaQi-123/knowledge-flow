package com.dataStructure.dataStructure.heap;

import java.util.PriorityQueue;

public class E02Leetcode703 {

    private MinHeap heap;

    public E02Leetcode703(int k, int[] nums) {
        heap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (!heap.isFull()) {
            heap.offer(val);
        } else if (val > heap.peek()) {
            heap.replace(val);
        }
        return heap.peek();
    }
}
