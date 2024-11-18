package com.dataStructure.algorithm.dynamicprogramming;

/**
 * 求斐波那契数列的第n项（动态规划）
 */
public class Fibonacci {

    public static void main(String[] args) {
        int fibonacci = fibonacci2(13);
        System.out.println(fibonacci);
    }

    public static int fibonacci(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 降维动态规划，使用两个变量即可，不需要整个数组
     *
     * @param n 斐波那切数列第n项
     * @return 第n项的值
     */
    public static int fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
