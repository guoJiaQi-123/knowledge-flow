package com.dataStructure.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序 { 可处理负数 }
 */
public class E09CountingSort {
    /*
        要点
        1. 让原始数组的最小值映射到 count[0] 最大值映射到 count 最右侧
        2. 原始数组元素 - 最小值 = count 索引
        3. count 索引 + 最小值 = 原始数组元素
     */
    public static void countSort(int[] a) {
        // 1.遍历数组，拿到数组中的最大值和最小值
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        // 2.实例化一个数组长度为 max - min + 1 的新数组
        int[] count = new int[max - min + 1];
        // 3.遍历原始数组，将原始数组中的(值 - min)与count数组索引做映射
        // 可以通过值 - min的方式将所有数据全部映射为大于零的数
        for (int v : a) {
            count[v - min]++; // v 原始数组元素 - 最小值 = count 索引
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                // i + min 代表原始数组元素 count[i] 代表元素出现次数
                a[k++] = i + min;
                count[i]--;
            }
        }
    }
}
