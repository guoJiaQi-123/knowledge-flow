package com.dataStructure.leetcode.stock_problem;

/**
 * @author OldGj 2024/03/07
 * @version v1.0
 * @apiNote <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/">
 * 123. 买卖股票的最佳时机 III  - 只能买两次
 * </a>
 */
public class MaxProfitLeetcode123 {

    /*
        动态规划：
            第一次买，不依赖之前状态，以当日价格买入
            第一次卖，依赖于昨天第一次买 + 当日价格

            第二次买，依赖于昨天第一次卖 - 当日价格
            第二次卖，依赖于昨天第二次买 + 当日价格
     */

    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }
}
