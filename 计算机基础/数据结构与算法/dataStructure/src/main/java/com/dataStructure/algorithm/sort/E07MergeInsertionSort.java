package com.dataStructure.algorithm.sort;


import java.util.Arrays;

/**
 * 归并 + 插入排序
 */
public class E07MergeInsertionSort {
    public static void mergeInsertionSort(int[] a) {
        int[] a2 = new int[a.length];
        split(a, 0, a.length - 1, a2);
    }

    //归并排序分区方法
    private static void split(int[] a, int left, int right, int[] a2) {
        // 治：当分区范围 <= 32后，采用插入排序实现有序
        // 传统的归并排序必须等到 left == right 即分区范围内只有一个元素时才视为有序
        // 通过整合插入排序，可以对小范围内（<=32）的元素直接采用插入排序后即可视为有序
        // 不用一直递归调用到分区内只有一个元素，提高效率和性能
        if (right - left <= 32) {
            //插入排序
            insertionSort(a, left, right);
            return;
        }
        // 分
        int mid = (right - left) >>> 1;
        split(a, left, mid, a2);
        split(a, mid + 1, right, a2);
        // 合
        merge(a, left, mid, mid + 1, right, a2);
        System.arraycopy(a2, left, a, left, right - left + 1);
    }

    /**
     * 插入排序
     */
    private static void insertionSort(int[] a, int left, int right) {
        for (int low = left + 1; low <= right; low++) {
            //定义一个变量t记录未排序区域的第一个值
            int t = a[low];
            //定义一个指针 i 为已排序区域的最后一个值的指针
            int i = low - 1;
            while (i >= left && a[i] > t) {
                a[i + 1] = a[i];
                i--;
            }
            //循环结束，说明找到了插入位置，插入即可
            if (i != low - 1) {
                a[i + 1] = t;
            }
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
        System.out.println(Arrays.toString(ints));
        mergeInsertionSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
