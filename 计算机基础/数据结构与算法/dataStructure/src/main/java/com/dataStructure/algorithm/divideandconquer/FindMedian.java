package com.dataStructure.algorithm.divideandconquer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <h3>数组中的中位数 - 快速选择</h3>
 */
public class FindMedian {

    /*
        奇数个
            1   4   5               ==> 4       3/2 = 1
            1   3   4   5   6       ==> 4       5/2 = 2
        偶数个
            0   1   2   3
            1   3   4   5           ==> 3.5     4/2
                                                4/2-1
     */

    public static void main(String[] args) {
        System.out.println("奇数");
        System.out.println(findMedian(new int[]{4, 5, 1}));          // 4.0
        System.out.println(findMedian(new int[]{4, 5, 1, 6, 3}));    // 4.0
        System.out.println("偶数");
        System.out.println(findMedian(new int[]{3, 1, 5, 4}));       // 3.5
        System.out.println(findMedian(new int[]{3, 1, 5, 4, 7, 8})); // 4.5
    }



    public static double findMedian(int[] nums) {
        if (nums.length % 2 == 1) { // 奇数
            return quickSelect(nums, 0, nums.length - 1, nums.length / 2);
        } else { // 偶数
            int x = quickSelect(nums, 0, nums.length - 1, nums.length / 2);
            int y = quickSelect(nums, 0, nums.length - 1, nums.length / 2 - 1);
            return (x + y) / 2.0;
        }
    }

    private static int quickSelect(int[] arrays, int left, int right, int index) {
        int p = partition(arrays, left, right);
        if (index == p) {
            return arrays[p];
        }
        if (index < p) {
            return quickSelect(arrays, left, p - 1, index);
        } else {
            return quickSelect(arrays, p + 1, right, index);
        }
    }

    private static int partition(int[] a, int left, int right) {
        //随机基准值
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a,index,left);

        int pv = a[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && a[i] < pv) {
                i++;
            }
            while (i <= j && a[j] > pv) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, left, j);
        return j;

    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
