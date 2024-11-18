package com.dataStructure.algorithm.dynamicprogramming;

/**
 * @author OldGj 2024/02/26
 * @version v1.0
 * @apiNote 卡特兰数 - Leetcode 96. 不同的二叉搜索树
 */
public class Catalan {

    public static void main(String[] args) {
        System.out.println(catalan(1));
        System.out.println(catalan(2));
        System.out.println(catalan(3));
        System.out.println(catalan(4));
        System.out.println(catalan(5));
    }

    /**
     * 求 n 的卡特兰数
     */
    private static int catalan(int n) {

        /*
            c(0)  1
            c(1)  1
            c(2)  c(0)*c(1) + c(1)*c(0) = 2
            c(3)  c(0)*c(2) + c(1)*c(1) + c(2)*c(0) = 5
            c(4)  c(0)*c(3) + c(1)*c(2) + c(2)c(1) + c(3)*c(0) = 14
         */
        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) { // 第i个卡特兰数的拆分
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }
}
