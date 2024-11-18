package com.dataStructure.leetcode;

import java.util.LinkedList;

/**
 * @author OldGj 2024/03/02
 * @version v1.0
 * @apiNote 42. 接雨水 - 需要采用单调栈数据结构
 */
public class TrappingRainWaterLeetcode42 {
    public int trap(int[] heights) {
        LinkedList<Data> stack = new LinkedList<>(); // 定义一个单调栈
        int sum = 0;
        for (int i = 0; i < heights.length; i++) { // 遍历柱子集合
            Data right = new Data(heights[i], i); // 即将放入单调栈中的柱子
            // 栈顶柱子小于待入栈柱子（不满足单调栈）
            while (!stack.isEmpty() && stack.peek().height < right.height) {
                Data pop = stack.pop(); // 从栈中pop出的柱子
                Data left = stack.peek(); // 栈中pop出柱子后的栈顶柱子
                if (left != null) {
                    int width = right.index - left.index - 1;
                    int height = Math.min(right.height, left.height) - pop.height;
                    sum += width * height;
                }
            }
            stack.push(right);
        }
        return sum;
    }

    static class Data {
        private final int height; // 柱子高度
        private final int index; // 柱子的索引

        public Data(int height, int index) {
            this.height = height;
            this.index = index;
        }

    }
}
