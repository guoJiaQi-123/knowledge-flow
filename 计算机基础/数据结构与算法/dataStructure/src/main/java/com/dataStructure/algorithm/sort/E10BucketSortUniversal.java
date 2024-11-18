package com.dataStructure.algorithm.sort;

import com.dataStructure.dataStructure.array.DynamicArray;
import com.dataStructure.dataStructure.heap.MinHeap;

import java.util.Arrays;

/**
 * 桶排序 { 通用 }
 */
public class E10BucketSortUniversal {

    /**
     * 桶排序
     * @param a 待排序数组
     * @param range 每个桶的大小
     */
    public static void bucketSort(int[] a, int range) {
        int max = a[0];
        int min = a[0];
        for (int j : a) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
        // 1. 准备桶 桶的数量为(max-min)/range + 1
        DynamicArray[] buckets = new DynamicArray[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new DynamicArray();
        }
        // 2. 放入数据  数据与桶的映射关系为：i数据要放入(i-min)/range桶中
        for (int i : a) {
            buckets[(i - min) / range].addLast(i);
        }
        int k = 0;
        for (DynamicArray bucket : buckets) {
            // 3.排序桶内元素
            int[] array = bucket.stream().toArray();
            E04InsertionSort.insertionSort(array);
            for (int value : array) {
                a[k++] = value;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {9, 8, 7, 5, 4, 2, 1, 5, 40};
        E10BucketSortUniversal.bucketSort(ints,3);
        System.out.println(Arrays.toString(ints));
    }
}
