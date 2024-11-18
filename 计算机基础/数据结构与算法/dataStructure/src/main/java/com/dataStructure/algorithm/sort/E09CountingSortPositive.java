package com.dataStructure.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序 { 只能处理处理 >=0 的数据 }
 *
 *     要点
 *       1. 找到最大值，创建一个大小为 最大值+1 的 count 数组
 *       2. count 数组的索引对应原始数组的元素，用来统计该元素的出现次数
 *       3. 遍历 count 数组，根据 count 数组的索引（即原始数组的元素）以及出现次数，生成排序后内容
 *           count 数组的索引是：已排序好的
 *       前提：待排序元素 >=0 且最大值不能太大
 *
 */
public class E09CountingSortPositive {
    public static void countingSort(int[] a) {
        // 1.获取数组最大值
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        // 2.创建一个长度为数组最大值 + 1的新数组
        int[] count = new int[max + 1];
        // 3.遍历原始数组，将对应数据索引处的值++（统计该元素的出现次数）
        for (int v : a) {
            count[v]++;
        }
        /*
            a [ 0 1 5 7 8 9]

            count [ 1 1 0 0 0 1 0 1 1 1 ]
                    0 1 2 3 4 5 6 7 8 9
        */
        //定义一个指针k操作原始数组
        int k = 0;
        // 4.遍历count数组，将值大于0处的索引值添加到原始数组中
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                a[k++] = i;
                // 5.添加完成后，对应索引处的值--（表示出现次数-1）
                count[i]--;
            }
        }
    }
}
