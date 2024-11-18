package com.dataStructure.algorithm.dynamicprogramming;

/**
 * @author OldGj 2024/02/26
 * @version v1.0
 * @apiNote 198. 打家劫舍 - 动态规划解法
 */
public class Leetcode198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        /*
                1   2   3   1
            1   1   0   0   0
            2   1   2   0   0
            3   1   2   4   0
            4   1   2   4   4
            dp[i] = max(dp[i-1], dp[i-2]+value);
         */
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Integer.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }
}
