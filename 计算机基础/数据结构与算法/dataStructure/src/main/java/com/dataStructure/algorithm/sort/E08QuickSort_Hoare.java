package com.dataStructure.algorithm.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <h3>双边循环快排</h3>
 * <ol>
 * <li>选择最左元素作为基准点元素</li>
 * <li>j 指针负责从右向左找比基准点小或等的元素，i 指针负责从左向右找比基准点大的元素，一旦找到二者交换，直至 i，j 相交</li>
 * <li>最后基准点与 i（此时 i 与 j 相等）交换，i 即为分区位置</li>
 * </ol>
 */
public class E08QuickSort_Hoare {
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

    private static int partition(int[] a, int left, int right) {
        /***************************随机元素作为基准点***************************/
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a,index,left);
        /***************************随机元素作为基准点***************************/
        int pv = a[left];
        int i = left;
        int j = right;
        while (i < j) {
            // 1. j 从右向左找小(等)的
            while (i < j && a[j] > pv) {
                j--;
            }
            // 2. i 从左向右找大的
            while (i < j && a[i] <= pv) {
                i++;
            }
            // 3. 交换位置
            swap(a, i, j);
        }
        swap(a, i, left);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] ints = {1, 23, 4, 0, 3, 3, 2, 9, 7, 6};
        E08QuickSort_Hoare.quickSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
