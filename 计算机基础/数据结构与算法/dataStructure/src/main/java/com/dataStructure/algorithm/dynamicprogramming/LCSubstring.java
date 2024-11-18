package com.dataStructure.algorithm.dynamicprogramming;

/**
 * @author OldGj 2024/02/22
 * @version v1.0
 * @apiNote 最长公共子串 - 动态规划
 */
public class LCSubstring {

    public static void main(String[] args) {
        System.out.println(lcs("itheima", "thema"));
    }

    /*
            i   t   h   e   i   m   a
         t  0   1   0   0   0   0   0
         h  0   0   2   0   0   0   0
         e  0   0   0   3   0   0   0
         m  0   0   0   0   0   1   0
         a  0   0   0   0   0   0   2

     */

    private static int lcs(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        int max = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    max = Integer.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

}
