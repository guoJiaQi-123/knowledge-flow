package com.dataStructure.algorithm.sort;

/**
 * 选择排序
 */
public class E02SelectionSort {
    public static void selectionSort(int[] a) {
        // 1. 选择轮数：a.length - 1
        // 2. 交换的索引right初始化为a.length - 1，每次递减，将选择到的最大值与right位置交换
        for (int right = a.length - 1; right > 0; right--) {
            int max = right;
            for (int i = 0; i < right; i++) {
                if (a[i] > a[max]) {
                    max = i;
                }
            }
            // max 值发生了变化才交换，否则不需要交换
            if (max != right) {
                // 每一轮循环结束时，将选择到的最大的的值交换到最右侧
                swap(a, max, right);
            }
        }
    }

    // 交换数组中两个索引位置的值
    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
