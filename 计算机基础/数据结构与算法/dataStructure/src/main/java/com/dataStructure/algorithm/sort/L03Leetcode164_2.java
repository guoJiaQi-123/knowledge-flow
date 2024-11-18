package com.dataStructure.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 164. 最大间距:桶排序
 */
public class L03Leetcode164_2 {
    public int maximumGap(int[] nums) {
        // 1.处理特殊情况
        if (nums.length < 2) {
            return 0;
        }

        // 2.桶排序，根据元素个数不同创建不同个数的桶
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        // (max-min)/range + 1 = nums.length -> 期望的桶的个数为数组长度
        // 2.1根据桶的个数可以推断出每个桶内装的元素个数
        int range = Math.max((max - min) / (nums.length - 1), 1);
        // 2.2初始化桶
        ArrayList<Integer>[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList();
        }
        // 2.3将数据放入对应的桶中
        for (int num : nums) {
            buckets[(num - min) / range].add(num);
        }
        // 2.4从桶中取数据
        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
            // 2.5遍历每个桶，对桶内元素进行排序
            Collections.sort(bucket);
            // 2.6把桶内排序好的元素，依次放入原始数组
            for (Integer i : bucket) {
                nums[k++] = i;
            }
        }
        // 3.计算最大间距
        int maximum = 0;
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i - 1];
            // 从第二位开始，每次取前一位与当前位作差，如果大于maximum，则更新maximum的值
            maximum = Math.max(maximum, nums[i] - x);
        }
        return maximum;
    }
}
