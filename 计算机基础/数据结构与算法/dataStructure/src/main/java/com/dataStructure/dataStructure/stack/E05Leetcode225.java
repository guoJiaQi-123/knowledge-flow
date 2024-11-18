package com.dataStructure.dataStructure.stack;

import com.dataStructure.dataStructure.queue.ArrayQueue5;

public class E05Leetcode225 {
    ArrayQueue5<Integer> queue = new ArrayQueue5<>(100);

    private int size = 0;

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
        size++;
    }

    public int pop() {
        size--;
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
