package com.dataStructure.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h3>双边循环快排 - 处理相等元素</h3>
 */
public class E08QuickSortHandleDuplicate {
    public static void quickSort(int[] a) {
        doQuickSort(a, 0, a.length - 1);
    }

    private static void doQuickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(a, left, right);
        doQuickSort(a, left, p - 1);
        doQuickSort(a, p + 1, right);
    }

    /*
            循环内
                i 从 left + 1 开始，从左向右找大的或相等的
                j 从 right 开始，从右向左找小的或相等的
                交换，i++ j--

            循环外 j 和 基准点交换，j 即为分区位置
    */
    private static int partition(int[] a, int left, int right) {
        //随机基准值
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a, left, index);
        int pv = a[left]; //基准值
        int i = left + 1;
        int j = right;
        //处理重复值
        while (i <= j) {
            // i 从左向右找大的或者相等的
            while (i <= j && a[i] < pv) {
                i++;
            }
            // j 从右向左找小的或者相等的
            while (i <= j && a[j] > pv) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, left, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] ints = {9, 5, 7, 8, 8, 4, 5, 9, 8, 7, 4, 5, 6, 2, 1, 5, 9};
        E08QuickSortHandleDuplicate.quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
