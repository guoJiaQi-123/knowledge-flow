package com.dataStructure.algorithm.greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * <b>0-1背包问题 - 贪心解法</b><br/>
 *    -可能得不到最优解
 */
public class KnapsackProblem {
    /*
    1. n个物品都是固体，有重量和价值
    2. 现在你要取走不超过 10克 的物品
    3. 每次可以不拿或全拿，问最高价值是多少

        编号 重量(g)  价值(元)
        0   1       1_000_000      钻戒一枚
        1   4       1600           黄金一块
        2   8       2400           红宝石戒指一枚
        3   5       30             白银一块

     */

    static class Item {
        int index;
        int weight;
        int value;

        public Item(int index, int weight, int value) {
            this.index = index;
            this.weight = weight;
            this.value = value;
        }

        public int unitValue() {
            return value / weight;
        }

        @Override
        public String toString() {
            return "Item(" + index + ")";
        }
    }

    public static void main(String[] args) {
        Item[] items = new Item[]{
                new Item(0, 1, 1_000_000),
                new Item(1, 4, 1600),
                new Item(2, 8, 2400),
                new Item(3, 5, 30)
        };
        int maxValue = select(items, 10);
        System.out.println(maxValue);
    }

    /**
     * 在背包中选择价值最多的物品取出，物品无法拆分取，一个物品要么全取，要么全不取
     *  @param items 所有物品
     *  @param total 物品数量
     *  @return 最大价值
     */
    private static int select(Item[] items, int total) {
        Arrays.sort(items, Comparator.comparingInt(Item::unitValue).reversed());
        int maxValue = 0;
        for (Item item : items) {
            if (item.weight <= total) {
                maxValue += item.value;
                total -= item.weight;
            }
        }
        return maxValue;
    }
}
