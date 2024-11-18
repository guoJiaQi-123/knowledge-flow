package com.dataStructure.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/03/01
 * @version v1.0
 * @apiNote 239. 滑动窗口最大值
 */
public class SlidingWindowMaximumLeetcode239 {

    /**
     *  单调递减队列
     */
    static class MonotonicStack {
        private final LinkedList<Integer> deque = new LinkedList<>();

        // 查看递减队列的第一个元素
        public Integer peek() {
            return deque.peekFirst();
        }

        // 查看并移除递减队列的第一个元素
        public Integer poll() {
            return deque.pollFirst();
        }

        // 向递减队列中添加元素
        public void offer(Integer m) {
            while (!deque.isEmpty() && deque.peekLast() < m) {
                deque.pollLast();
            }
            deque.offerLast(m);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 3 -1 -3
        MonotonicStack queue = new MonotonicStack();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i >= k && nums[i - k] == queue.peek()) {
                queue.poll();
            }
            queue.offer(num);
            if (i >= (k - 1)) {
                list.add(queue.peek());
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
