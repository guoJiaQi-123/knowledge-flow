package com.dataStructure.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote LeetCode 62 - uniquePaths不同路径
 */
public class LeetCode62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 初始化第一列的值为1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        // 初始化第一行的值为1
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 每一格的值都为：同列上一行格的值+同行上一列格的值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 0  1 2  3  4  5  6
    // 1  1 1  1  1  1  1
    // 1  2 3  4  5  6  7
    // 1  3 6 10 15  21 28


    // 1  1 1  1  1  1  1
    // 1  2 3  4  5  6  7


    // 降维
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
