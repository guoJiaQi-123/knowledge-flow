package com.dataStructure.algorithm.sort;

import java.util.ArrayList;

/**
 * 164. 最大间距:基数排序
 */
public class L03Leetcode164 {
    public int maximumGap(int[] nums) {
        // 1.处理特殊情况:数组长度小于2，直接返回0
        if (nums.length < 2) {
            return 0;
        }
        // 2.采用基数排序对数组进行排序
        // 找数组中的最大值
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 初始化十个桶
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }
        int m = 1;
        while (m <= max) {
            // 从个位数开始，每一轮将个位，十位，百位依次放入桶中再取出
            for (int i : nums) {
                buckets[i / m % 10].add(i);// 每一轮将个位，十位，百位依次放入桶
            }
            int k = 0;
            for (ArrayList<Integer> bucket : buckets) {
                for (Integer i : bucket) {
                    // 依次从桶中取出再到nums数组中
                    nums[k++] = i;
                }
                //一轮结束，清空桶
                bucket.clear();
            }
            // m*10，下次取百位，千位...
            m *= 10;
        }
        // 3.寻找最大差值
        int maximum = 0;
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i - 1];
            // 从第二位开始，每次取前一位与当前位作差，如果大于maximum，则更新maximum的值
            if (nums[i] - x > maximum) {
                maximum = nums[i] - x;
            }
        }
        return maximum;
    }

}
