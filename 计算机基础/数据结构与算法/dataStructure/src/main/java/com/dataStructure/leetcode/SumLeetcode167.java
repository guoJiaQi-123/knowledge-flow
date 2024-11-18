package com.dataStructure.leetcode;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 167. 两数之和 II - 输入有序数组
 */
public class SumLeetcode167 {
    /*
        思路：定义两个指针i , j 其中，i指向数组左边，j指向数组左边
            每次将i指向的元素和j指向的元素相加得到结果sum
            如果sum大于target，则说明两数之和大于目标数，希望目标数可以减少
            （利用了原本数组有序的特性，希望和变大则左指针右移即可，希望和变小则右指针左移即可）
            此时将j--，再次计算和，再次比较...
            如果sum小于target，则说明两数之和小于目标数，希望目标数可以增加
            此时将i++，再次计算和，再次比较
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                break;
            }
        }
        return new int[]{i + 1, j + 1};
    }
}
