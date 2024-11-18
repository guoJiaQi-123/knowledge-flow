package com.dataStructure.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author OldGj 2024/02/26
 * @version v1.0
 * @apiNote Leetcode 22. 括号生成 - 动态规划解法
 */
public class Leetcode22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>(List.of(""));
        dp[1] = new ArrayList<>(List.of("()"));
        for (int i = 2; i < n + 1; i++) {
            dp[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) { // 第i个卡特兰数的拆分
                for (String k1 : dp[j]) { // 内层嵌套
                    for (String k2 : dp[i - 1 - j]) { // 外层平级
                        dp[i].add("(" + k1 + ")" + k2);
                    }
                }
            }
        }
        return dp[n];
    }
}
