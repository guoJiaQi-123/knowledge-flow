package com.dataStructure.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class E05ShellSort {
    /**
     * 希尔排序
     */
    public static void shellSort(int[] a) {
        // 定义分组间隙 gap ，初始为数组长度的一半，每次循环右位移一位（除以二）
        for (int gap = a.length >> 1; gap >= 1; gap = gap >> 1) {
            for (int low = gap; low < a.length; low++) {
                // 未排序区域的第一个元素值
                int t = a[low];
                // 已排序区域的最后一个元素指针
                int i = low - gap;
                // Insertion sort
                while (i >= 0 && a[i] > t) {
                    a[i + gap] = a[i];
                    i -= gap;
                }
                if (i != low - gap) {
                    a[i + gap] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {9, 5, 7, 8, 4, 1, 2, 3, 5, 4, 7};
        E05ShellSort.shellSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
