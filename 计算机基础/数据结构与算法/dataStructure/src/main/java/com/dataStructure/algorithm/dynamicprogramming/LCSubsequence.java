package com.dataStructure.algorithm.dynamicprogramming;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 最长公共子序列 Leetcode 1143 - 动态规划
 */
public class LCSubsequence {

    /*
                a   b   c   d   e
            0   0   0   0   0   0
         a  0   1   1   1   1   1
         c  0   1   1   2   2   2
         e  0   1   1   2   2   3

                a   b   c   d   e
            0   0   0   0   0   0
         a  0   1   1   1   1   1
         e  0   1   1   1   1   2
         c  0   1   1   2   2   2

         相同字符
            找到上一行上一列数值 + 1
         不同字符
            max(上一行, 上一列)


     */

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int i = longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}
