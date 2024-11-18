package com.dataStructure.algorithm.sort;

/**
 * 1122. 数组的相对排序
 *       核心思想：计数排序
 *              将数组1中的数据放入count数组
 *              读取时先按照数组2中的顺序读取，再从0开始读取
 */
public class L01Leetcode1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 定义数组长度为1001（题意得数组中的最大值为1000）的count数组，索引为元素值，数组值为元素出现的次数
        int[] count = new int[1001];
        // 遍历数组1，将数组1中的数据作为count数组下标，对应下标++，记录该值出现的次数
        for (int i : arr1) {
            count[i]++;
        }
        // 定义指针k,用于操作result结果数组
        int k = 0;
        // 定义一个结果数组，用于存放遍历结果
        int[] result = new int[arr1.length];
        // 核心步骤：根据数组2中的顺序，先读取一次count数组中的值并将其放入结果数组
        for (int i : arr2) {
            while (count[i] > 0) {
                result[k++] = i;
                count[i]--;
            }
        }
        // 根据数组2中的顺序读取之后再从0开始读取不存在数组2中的值
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[k++] = i;
                count[i]--;
            }
        }
        return result;
    }
}
