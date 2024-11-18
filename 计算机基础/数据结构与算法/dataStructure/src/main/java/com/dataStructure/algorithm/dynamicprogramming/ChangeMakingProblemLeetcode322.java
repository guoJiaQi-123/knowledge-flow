package com.dataStructure.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 零钱兑换问题 - 动态规划<p>凑成总金额的凑法中，需要硬币最少个数是几？</p>
 */
public class ChangeMakingProblemLeetcode322 {


    public static void main(String[] args) {
        int i = coinChange2(new int[]{2}, 3);
        System.out.println(i);
    }

    /*
     面值    0        1        2        3        4        5
       1    0        1        11       111      1111     11111
       2    0        1        2        21       22       221
       5    0        1        2        21       22       5

     面值    0        1        2        3        4        5
      10    0        max      max      max      max      max

     总金额❤  - 类比为背包容量
     硬币面值  - 类比为物品重量
     硬币个数  - 类比为物品价值，固定为1 （求价值(个数)最小的）

     if(装得下) {
        min(上次价值(个数), 剩余容量能装下的最小价值(个数)+1)
        dp[i][j] = min(dp[i-1][j], dp[i][j-item.weight] + 1)
     } else {
        保留上次价值(个数)不变
        dp[i][j] = dp[i-1][j]
     }
     */

    /**
     * 零钱兑换问题 - 动态规划
     * @param coins 硬币面值数组
     * @param amount 要凑的面值
     * @return 最少硬币数
     */
    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        // 初始化
        int coin0 = coins[0];
        for (int j = 1; j < amount + 1; j++) {
            if (j >= coin0) {
                dp[0][j] = dp[0][j - coin0] + 1;
            } else {
                dp[0][j] = amount + 1;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coin) {  // 放得下
                    dp[i][j] = Integer.min(dp[i - 1][j], dp[i][j - coin] + 1);
                } else { //放不下
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length - 1][amount] <= amount ? dp[coins.length - 1][amount] : -1;
    }

    /**
     * 降维
     * @param coins 硬币面值数组
     * @param amount 要凑的面值
     * @return 最少硬币数
     */
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 初始化
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = Integer.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] <= amount ? dp[amount] : -1;
    }
}
