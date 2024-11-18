package com.dataStructure.algorithm.dynamicprogramming;

import java.util.Arrays;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 完全背包问题 - 动态规划解法
 *
 */
public class KnapsackProblemComplete {

    static class Item {
        int index;
        String name;
        int weight;
        int value;

        public Item(int index, String name, int weight, int value) {
            this.index = index;
            this.name = name;
            this.weight = weight;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item(" + name + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(1, "青铜", 2, 3),    // c
                new Item(2, "白银", 3, 4),    // s
                new Item(3, "黄金", 4, 7),    // a
        };
        System.out.println(select(items, 6));
    }

    /*
            0   1   2   3   4   5   6
        1   0   0   c   c   cc  cc  ccc     青铜 重2
        2   0   0   c   s   cc  sc  ccc     白银 重3
        3   0   0   c   s   a   a   ac      黄金 重4

        if(放得下) {
            dp[i][j] = max(dp[i-1][j], dp[i][j-item.weight] + item.value)
        } else {
            dp[i][j] = dp[i-1][j]
        }
     */

    /**
     * 动态规划 完全背包问题
     * @param items 所有物品
     * @param total 背包容量
     * @return 最大价值
     */
    private static int select2(Item[] items, int total) {
        int[][] dp = new int[items.length][total + 1];
        // 初始化
        Item item0 = items[0];
        for (int j = 0; j < total + 1; j++) {
            if (j >= item0.weight) { // 放得下
                dp[0][j] = dp[0][j - item0.weight] + item0.value;
            }
        }
        for (int i = 1; i < items.length; i++) {
            Item item = items[i];
            for (int j = 0; j < total + 1; j++) {
                // x: 上一次同容量背包的最大价值
                int x = dp[i - 1][j];
                if (j >= item.weight) {// 放得下
                    // j-item.weight: 当前背包容量-这次物品重量=剩余背包空间 -> 在当前行 i 找
                    dp[i][j] = Integer.max(x, dp[i][j - item.weight] + item.value);
                } else {
                    dp[i][j] = x;
                }
            }
        }
        return dp[items.length - 1][total];
    }

    /**
     * 降维 - 空间优化
     * @param items 所有物品
     * @param total 背包容量
     * @return 最大价值
     */
    private static int select(Item[] items, int total) {
        int[] dp = new int[total + 1];
        for (Item item : items) {
            for (int j = 0; j < total + 1; j++) {
                if (j >= item.weight) {// 放得下
                    dp[j] = Integer.max(dp[j], dp[j - item.weight] + item.value);
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[total];
    }
}
