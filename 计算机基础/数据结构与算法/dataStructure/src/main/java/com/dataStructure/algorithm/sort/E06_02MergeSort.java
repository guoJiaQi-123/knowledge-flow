package com.dataStructure.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序<子下至上-非递归>
 */
public class E06_02MergeSort {

    public static void MergeSort(int[] a1) {
        int n = a1.length;
        int[] a2 = new int[n];
        // width 代表有序区间的宽度，取值依次为 1,2,4 ...
        for (int width = 1; width < n; width = width * 2) {
            // [left,right] 分别代表合并区间的左右边界
            // 每次合并两个有序区间，因此左边界每次循环 ＋ 2 * width
            for (int left = 0; left < n; left += 2 * width) {
                //右边界为下次左边界 - 1
                int right = Math.min(left + 2 * width - 1, n - 1);
                //中间值mid为左边界 + 一个宽度width - 1
                int mid = Math.min(left + width - 1, n - 1);
                merge(a1, left, mid, mid + 1, right, a2);
            }
            System.arraycopy(a2, 0, a1, 0, n);
        }
    }

    /**
     * 合并有序数组
     *
     * @param a1 原始数组
     * @param i  iEnd 第一个有序范围
     * @param j  jEnd 第二个有序范围
     * @param a2 临时数组
     */
    private static void merge(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        //定义变量k为操作临时数组的指针
        int k = i;
        //如果i和j都在有效范围内
        while (i <= iEnd && j <= jEnd) {
            //比较i和j处索引的数组的值，并把较小的值加入到临时数组a2中
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            //更新操作临时数组的指针
            k++;
        }
        // 当i > iEnd说明第一个有序范围内的元素已经全部迭代，将第二范围内没有被迭代的元素拷贝到a1数组即可
        if (i > iEnd) {
            System.arraycopy(a1, j, a2, k, jEnd - j + 1);
        }
        // 当j > jEnd说明第二个有序范围内的元素已经全部迭代，将第一范围内没有被迭代的元素拷贝到a1数组即可
        if (j > jEnd) {
            System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        }
    }

    public static void main(String[] args) {
        int[] ints = {9, 5, 4, 7, 8, 1, 2, 3, 6, 5, 4, 8};
        MergeSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
