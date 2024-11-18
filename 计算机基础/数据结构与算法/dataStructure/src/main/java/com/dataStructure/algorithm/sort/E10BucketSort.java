package com.dataStructure.algorithm.sort;
import com.dataStructure.dataStructure.array.DynamicArray;
import java.util.Arrays;

/**
 * 桶排序
 */
public class E10BucketSort {
    public static void bucketSort(int[] a) {
        // 十个桶
        DynamicArray[] buckets = new DynamicArray[10];
        //初始化桶
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new DynamicArray();
        }
        //将a数组中的数据放入对应的桶中
        for (int i : a) {
            buckets[i / 10].addLast(i);
        }
        int k = 0;
        for (DynamicArray bucket : buckets) {
            int[] array = bucket.stream().toArray();
            //对每个桶中的数据进行排序
            E04InsertionSort.insertionSort(array);
            for (int v : array) {
                a[k++] = v;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {18, 54, 23, 65, 9, 87, 54, 21, 45, 87};
        E10BucketSort.bucketSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
