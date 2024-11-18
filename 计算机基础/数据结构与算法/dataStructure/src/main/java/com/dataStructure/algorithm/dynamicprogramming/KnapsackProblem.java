package com.dataStructure.algorithm.dynamicprogramming;

/**
 * @author HX 2024/02/19
 * @version v1.0
 * @apiNote 0-1 背包问题 - 动态规划解法
 */
public class KnapsackProblem {
    /*
        1. n个物品都是固体，有重量和价值
        2. 现在你要取走不超过 10克 的物品
        3. 每次可以不拿或全拿，问最高价值是多少

            编号 重量(g)  价值(元)                        简称
            1   4       1600           黄金一块   400    A
            2   8       2400           红宝石一粒 300    R
            3   5       30             白银一块          S
            0   1       1_000_000      钻石一粒          D
        1_001_630

        1_002_400
     */

    /*
            1   2   3   4   5   6   7   8   9   10
       A    0   0   0   a   a   a   a   a   a   a
       R    0   0   0   a   a   a   a   r   r   r
       S    0   0   0   a   a   a   a   r   r   r
       D    d   d   d   d   da  da  da  da  dr  dr
     */
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
                new Item(1, "黄金", 4, 1600),
                new Item(2, "宝石", 8, 2400),
                new Item(3, "白银", 5, 30),
                new Item(4, "钻石", 1, 10_000),
        };
        System.out.println(select(items, 10));
    }

    /**
     * 降维 - 空间优化
     *
     * @param items 全部物品
     * @param total 背包容量
     * @return 最大价值
     */
    private static int select(Item[] items, int total) {
        int[] dp = new int[total + 1];
        for (Item item : items) {
            for (int i = total; i > 0; i--) {
                if (i >= item.weight) {//装得下
                    dp[i] = Integer.max(dp[i], dp[i - item.weight] + item.value);
                }
            }
        }
        return dp[total];
    }


    /**
     * 在有限容量内选择最大价值物品 物品不可拆分（0-1）
     *
     * @param items 所有物品
     * @param total 背包容量
     * @return 最大价值
     */
    private static int select2(Item[] items, int total) {
        int[][] dp = new int[items.length][total + 1];
        // 对DP数组的第一行初始化
        Item item0 = items[0];
        for (int j = 0; j < total; j++) {
            if (j >= item0.weight) { // 装得下
                dp[0][j] = item0.value;
            } else { // 装不下
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            Item item = items[i];
            for (int j = 1; j < total + 1; j++) {
                // x: 上一次同容量背包的最大价值
                int x = dp[i - 1][j];
                if (j >= item.weight) { // 装的下
                    // j-item.weight: 当前背包容量-这次物品重量=剩余背包空间
                    // y: 剩余背包空间能装下的最大价值 + 这次物品价值
                    int y = dp[i - 1][j - item.weight] + item.value;
                    dp[i][j] = Integer.max(x, y);
                } else { // 装不下
                    dp[i][j] = x;
                }
            }
        }
        return dp[dp.length - 1][total];
    }
}
