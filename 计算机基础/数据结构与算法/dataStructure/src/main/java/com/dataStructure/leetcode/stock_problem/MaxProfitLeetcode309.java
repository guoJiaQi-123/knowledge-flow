package com.dataStructure.leetcode.stock_problem;

/**
 * @author OldGj 2024/03/07
 * @version v1.0
 * @apiNote <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">
 * 309. 买卖股票的最佳时机含冷冻期
 * </a>
 */
public class MaxProfitLeetcode309 {


    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(sell[0], buy[0] + prices[1]);
        for (int i = 2; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}
