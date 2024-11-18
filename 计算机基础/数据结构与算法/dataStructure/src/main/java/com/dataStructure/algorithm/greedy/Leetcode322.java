package com.dataStructure.algorithm.greedy;

/**
 * <h3>零钱兑换 - 贪心解法</h3>
 * <p>贪心解法：可能得到错误的解</p>
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        /*
            总金额 18
            5   2   1

            1*5 13
            1*5 8
            1*5 3
            1*2 1
            1*1 0

            贪心的原则：
                1. 每一次都选取当前最优解
                2.《向前看，别回头》

            几个有问题的情况
            总金额 21
            15  10  1
            7 个硬币
            1*15 6
            6*1  0

            3 个硬币
            2*10
            1*1

            总金额 20
            15  10
            1*15 5  无解

            2*10
         */
        int remainder = amount;// 剩余金额
        int count = 0;// 需要几个硬币
        for (int coin : coins) {
            while (remainder > coin) {
                remainder -= coin;
                count++;
            }
            if (remainder == coin) {
                remainder = 0;
                count++;
                break;
            }
        }
        if (remainder == 0) {
            return count;
        } else {
            return -1;
        }
    }
}
