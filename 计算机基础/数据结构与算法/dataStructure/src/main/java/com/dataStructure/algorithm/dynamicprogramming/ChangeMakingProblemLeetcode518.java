package com.dataStructure.algorithm.dynamicprogramming;

/**
 * @author OldGj 2024/02/21
 * @version v1.0
 * @apiNote Leetcode518 零钱兑换2
 * <p>凑成总金额的凑法中，一共有几种凑法</p>
 */
public class ChangeMakingProblemLeetcode518 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int change = change(2500, coins);
        System.out.println(change);
    }

    /*
           0   1     2     3     4      5     总金额 - 背包容量
       1   1   1     11    111   1111   11111
              (1)    (1)   (1)   (1)    (1)

       2   1   1     11    111   1111   11111
                     2     21    211    2111
                                 22     21
              (1)    (2)   (2)   (3)    (3)

       5   1   1     11    111   1111   11111
                     2     21    211    2111
                                 22     21
                                        5
              (1)    (1)   (1)   (1)    (4)

     */


    public static  int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        // 初始化
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        int coin0 = coins[0];
        for (int j = 1; j < amount + 1; j++) {
            if (j >= coin0) {
                dp[0][j] = dp[0][j - coin0];
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (j >= coins[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[coins.length - 1][amount];
    }

    public int change3(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化1
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
}


