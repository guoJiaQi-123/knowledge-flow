package com.dataStructure.algorithm.dynamicprogramming;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 300. 最长递增子序列
 */
public class Leetcode300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    public static int lengthOfLIS(int[] nums) {

        /*
                2   4   8   5
                1   1   1   1
                1   2   1   1
                1   2   3   1
                1   2   3   3

                3

                10  9   2   5   3   7   101 18
                [1, 1,  1,  1,  1,  1,  1,  1]
                [1, 1,  1,  1,  1,  1,  1,  1]
                [1, 1,  1,  2,  1,  1,  1,  1]
                [1, 1,  1,  2,  2,  1,  1,  1]
                [1, 1,  1,  2,  2,  3,  1,  1]
                [1, 1,  1,  2,  2,  3,  4,  1]
                [1, 1,  1,  2,  2,  3,  4,  4]

         */
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return Arrays.stream(dp).max().getAsInt();

    }


}
