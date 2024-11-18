package com.dataStructure.leetcode.stock_problem;

import java.util.Arrays;

/**
 * @author OldGj 2024/03/07
 * @version v1.0
 * @apiNote <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/">
 * 188. 买卖股票的最佳时机 IV - 可以买 K 次
 * </a>
 */
public class MaxProfitLeetcode188 {



    public int maxProfit(int k, int[] prices) {
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int price : prices) {
            buy[0] = Math.max(buy[0], -price);
            sell[0] = Math.max(sell[0], buy[0] + price);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        return sell[k - 1];
    }

    public int maxProfit(int[] prices) {

        /*          4       3
                                j
                            i
            7   1   5   3   6   4
         */
        int i = 0;
        int j = 1;
        int result = 0;
        while (j < prices.length) {
            if (prices[j] - prices[i] > 0) { // 涨
                result += prices[j] - prices[i];
            }
            i++;
            j++;
        }
        return result;
    }
}
