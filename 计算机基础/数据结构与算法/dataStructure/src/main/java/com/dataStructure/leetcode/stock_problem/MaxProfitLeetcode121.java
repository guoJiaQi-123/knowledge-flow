package com.dataStructure.leetcode.stock_problem;

/**
 * @author OldGj 2024/03/07
 * @version v1.0
 * @apiNote <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">
 *          121. 买卖股票的最佳时机 - 买一次
 * </a>
 */
public class MaxProfitLeetcode121 {

    /*
        遇涨记录 max = Math.max(max, prices[j] - prices[i]);
        遇跌跳过 i = j;
     */

    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        /*
                        4   2   5   3
                                    j
                    i
                7   1   5   3   6   4
         */
        int max = 0;
        while (j < prices.length) {
            if (prices[j] - prices[i] > 0) { // 涨
                max = Math.max(max, prices[j] - prices[i]);
            } else { // 跌
                i = j;
            }
            j++;
        }
        return max;
    }
}
