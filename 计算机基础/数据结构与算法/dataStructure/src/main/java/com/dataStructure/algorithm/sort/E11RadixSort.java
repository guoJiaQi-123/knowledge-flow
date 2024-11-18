package com.dataStructure.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 基数排序{最低有效数字-LSD}
 */
public class E11RadixSort {
    public static void radixSort(String[] a, int length) {
        // 1.准备桶
        ArrayList<String>[] buckets = new ArrayList[128];
        // 2.初始化桶
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 3.从低位开始多轮桶排序
        for (int i = length - 1; i >= 0; i--) {
            // 4.将字符串放入合适的桶
            for (String v : a) {
                buckets[v.charAt(i)].add(v);
            }
            // 5.重新取出排好序的字符串，放回原始数组
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String s : bucket) {
                    a[k++] = s;
                }
                bucket.clear();
            }
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"153","156","138","172"};
        radixSort(strings,3);
        System.out.println(Arrays.toString(strings));
    }

}
