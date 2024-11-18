package com.dataStructure.leetcode.stock_problem;

/**
 * @author OldGj 2024/03/07
 * @version v1.0
 * @apiNote <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/">
 * 714. 买卖股票的最佳时机含手续费
 * </a>
 */
public class MaxProfitLeetcode714 {


    /**
     * 对于买： =》  1. 延续上次买的利润不变；
     * 2. 在上次卖的利润基础上买；
     * ------------------------
     * 对于卖： =》  1. 延续上次卖的利润不变；
     * 2. 在上次买的基础上卖；
     */
    public int maxProfit2(int[] prices, int fee) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }

    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int buy_new = Math.max(buy, sell - prices[i]);
            int sell_new = Math.max(sell, buy + prices[i] - fee);
            buy = buy_new;
            sell = sell_new;
        }
        return sell;
    }
}
