package com.dataStructure.leetcode.stock_problem;

/**
 * @author OldGj 2024/03/07
 * @version v1.0
 * @apiNote
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">
 *     122. 买卖股票的最佳时机 II - 买无限次
 *     </a>
 */
public class MaxProfitLeetcode122 {

    /*
        贪心思想，只要涨了就累加
     */

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
