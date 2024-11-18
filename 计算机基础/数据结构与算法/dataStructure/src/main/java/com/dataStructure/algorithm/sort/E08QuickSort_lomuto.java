package com.dataStructure.algorithm.sort;

import java.util.Arrays;

/**
 * <h3>单边循环快排（lomuto 洛穆托分区方案）</h3>
 * <p>核心思想：每轮找到一个基准点元素，把比它小的放到它左边，比它大的放到它右边，这称为分区</p>
 * <ol>
 * <li>选择最右元素作为基准点元素</li>
 * <li>j 找比基准点小的，i 找比基准点大的，一旦找到，二者进行交换</li>
 * <ul>
 * <li>交换时机：j 找到小的，且与 i 不相等</li>
 * <li>i 找到 >= 基准点元素后，不应自增</li>
 * </ul>
 * <li>最后基准点与 i 交换，i 即为基准点最终索引</li>
 * </ol>
 */
public class E08QuickSort_lomuto {
    public static void quickSort(int[] a) {
        doQuickSort(a, 0, a.length - 1);
    }

    private static void doQuickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(a, left, right);// p代表基准点元素索引
        doQuickSort(a, left, p - 1); // 对基准点左侧（小于基准点元素）递归调用快排方法
        doQuickSort(a, p + 1, right); // 对基准点右侧（大于基准点元素）递归调用快排方法
    }

    /**
     * lomuto分区方案
     */
    private static int partition(int[] a, int left, int right) {
        int pv = a[right]; //基准点的值
        int i = left; //记录大于基准点值的指针
        int j = left; //记录小于基准点值的指针
        while (j < right) {
            if (a[j] < pv) { // j 找到比基准点小的了, 没找到大的
                if (i != j) {
                    swap(a, i, j);
                }
                i++;
            }
            j++;
        }
        swap(a, i, right);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 56, 7, 45, 23, 423, 5236, 2};
        E08QuickSort_lomuto.quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
