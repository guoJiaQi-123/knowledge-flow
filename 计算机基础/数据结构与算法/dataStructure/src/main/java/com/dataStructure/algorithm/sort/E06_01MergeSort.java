package com.dataStructure.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序<自顶至下-递归>
 */
public class E06_01MergeSort {

    public static void mergeSort(int[] a) {
        int[] a2 = new int[a.length];
        split(a, 0, a.length - 1, a2);
    }

    private static void split(int[] a1, int left, int right, int[] a2) {
        // 2. 治
        if (left == right) {
            return;
        }
        // 1. 分
        int mid = (left + right) >>> 1;
        split(a1, left, mid, a2);
        split(a1, mid + 1, right, a2);
        // 3. 合
        merge(a1, left, mid, mid + 1, right, a2);
        System.arraycopy(a2, left, a1, left, right - left + 1);
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
        int[] ints = {9, 5, 4, 7, 1, 3, 6, 2, 5};
        mergeSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
