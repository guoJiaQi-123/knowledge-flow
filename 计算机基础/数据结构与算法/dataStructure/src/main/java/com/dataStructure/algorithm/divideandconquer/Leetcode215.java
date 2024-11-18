package com.dataStructure.algorithm.divideandconquer;

/**
 * @author OldGj 2024/02/27
 * @version v1.0
 * @apiNote 215. 数组中的第K个最大元素 - 快速选择算法
 */
public class Leetcode215 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int n) {

        int p = partition(nums, left, right);
        if (n == p) {
            return nums[p];
        }
        if (n < p) {
            return quickSelect(nums, left, p - 1, n);
        } else {
            return quickSelect(nums, p + 1, right, n);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pv = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[i] < pv) {
                i++;
            }
            while (i <= j && nums[j] > pv) {
                j--;
            }
            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
