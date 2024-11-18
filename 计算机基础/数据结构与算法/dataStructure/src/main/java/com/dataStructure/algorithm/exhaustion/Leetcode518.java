package com.dataStructure.algorithm.exhaustion;

/**
 * <h3>零钱兑换 II</h3>
 * <p>可以凑成总金额所需的所有组合可能数</p>
 *    暴力模拟
 */
public class Leetcode518 {
    public int change(int amount, int[] coins) {
        return rec(0, coins, amount);
    }

    /**
     * 求凑成剩余金额的解的个数
     *
     * @param index     当前硬币索引
     * @param remainder 剩余金额
     * @param coins     硬币面值数组
     * @return 解的个数
     */
    private int rec(int index, int[] coins, int remainder) {
        // 剩余金额为0，说明有解，可以正确兑换，返回1
        if (remainder == 0) {
            return 1;
        } else if (remainder < 0) { //剩余金额小于0，说明无解，无法正确兑换，返回0
            return 0;
        } else { // 剩余金额大于零，需要递归判断是否可以匹配其他面额的硬币使其可以正确兑换
            int count = 0;
            for (int i = index; i < coins.length; i++) {
                count += rec(i, coins, remainder - coins[i]);
            }
            return count;
        }
    }
}
