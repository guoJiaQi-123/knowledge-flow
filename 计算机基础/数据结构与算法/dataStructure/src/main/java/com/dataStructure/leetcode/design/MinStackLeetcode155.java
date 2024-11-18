package com.dataStructure.leetcode.design;

import java.util.LinkedList;

/**
 * @author OldGj 2024/03/04
 * @version v1.0
 * @apiNote 155.最小栈 - 使用两个栈结构
 */
public class MinStackLeetcode155 {


    static class MinStack {
        private final LinkedList<Integer> stack = new LinkedList<>();
        private final LinkedList<Integer> min = new LinkedList<>();

        public MinStack() {
            min.push(Integer.MAX_VALUE);
        }

        @SuppressWarnings("all")
        public void push(int val) {
            stack.push(val);
            min.push(Math.min(val, min.peek()));
        }


        public void pop() {
            if (!min.isEmpty() && !stack.isEmpty()) {
                stack.pop();
                min.pop();
            }
        }

        public int top() {
            return stack.isEmpty() ? -1 : stack.peek();
        }

        public int getMin() {
            return min.isEmpty() ? -1 : min.peek();
        }
    }
}
