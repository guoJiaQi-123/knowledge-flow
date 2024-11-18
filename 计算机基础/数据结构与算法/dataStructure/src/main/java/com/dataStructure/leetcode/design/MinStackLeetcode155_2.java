package com.dataStructure.leetcode.design;

import java.util.LinkedList;

/**
 * @author OldGj 2024/03/04
 * @version v1.0
 * @apiNote 155.最小栈 - 使用一个栈结构
 */
public class MinStackLeetcode155_2 {
    static class Source {
        private final int val;
        private final int min;

        public Source(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    static class MinStack {
        private final LinkedList<Source> stack = new LinkedList<>();

        public MinStack() {

        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new Source(val, val));
            } else {
                stack.push(new Source(val, Math.min(stack.peek().min, val)));
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().val;
        }

        public int getMin() {
            return stack.peek().min;
        }
    }
}
