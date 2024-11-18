package com.dataStructure.algorithm.dynamicprogramming;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 583. 两个字符串的删除操作
 */
public class Leetcode583 {
    /*
        求最长公共子序列
                l   e   e   t   c   o   d   e
            0   0   0   0   0   0   0   0   0
        e   0   0   1   1   1   1   1   1   1
        t   0   0   1   1   2   2   2   2   2
        c   0   0   1   1   2   3   3   3   3
        o   0   0   1   1   2   3   4   4   4

     */
    public int minDistance(String word1, String word2) {
        // 求最长公共子序列
        int m = word1.length();
        int n = word2.length();
        char[] array = word1.toCharArray();
        char[] array1 = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (array[i-1] == array1[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 需要删除的字符数 = 两个字符串的总字符数 - 2 * 最长公共子序列
        return m + n - 2 * dp[m][n];
    }
}
