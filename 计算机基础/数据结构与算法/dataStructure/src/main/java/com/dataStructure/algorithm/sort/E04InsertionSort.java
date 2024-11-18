package com.dataStructure.algorithm.sort;

/**
 * 插入排序
 */
public class E04InsertionSort {
    /**
     * 插入排序
     */
    public static void insertionSort(int[] a) {
        for (int low = 1; low < a.length; low++) {
            //定义一个变量t记录未排序区域的第一个值
            int t = a[low];
            //定义一个指针 i 为已排序区域的最后一个值的指针
            int i = low - 1;
            //已排序区域自右向左找插入位置，如果已排序区域中的值比t大，则不断右移，空出插入位置
            while (i >= 0 && a[i] > t) {
                a[i + 1] = a[i];
                i--;
            }
            //循环结束，说明找到了插入位置，插入即可
            if (i != low - 1) {
                a[i + 1] = t;
            }
        }
    }
}
