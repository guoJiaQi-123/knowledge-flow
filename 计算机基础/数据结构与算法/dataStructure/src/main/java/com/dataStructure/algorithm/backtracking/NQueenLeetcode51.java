package com.dataStructure.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 51. N 皇后
 */
public class NQueenLeetcode51 {
    public  static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        // 初始化棋盘
        char[][] table = new char[n][n];
        for (char[] chars : table) {
            Arrays.fill(chars, '.');
        }
        // 以4皇后为例
        // [ false,false,false,false ] 对应第0-3列是否有冲突
        boolean[] ca = new boolean[n]; // 表示列冲突的数组

        // 2 * n - 1 表示左斜线的条数，4*4的棋盘有7条左斜线
        boolean[] cb = new boolean[2 * n - 1]; // 表示左对角线冲突的数组
        boolean[] cc = new boolean[2 * n - 1]; // 表示右对角线冲突的数组
        dfs(0, n, table, ca, cb, cc, result);
        return result;
    }

    /**
     * @param i      处理第n行
     * @param table  棋盘
     * @param ca     列冲突
     * @param cb     左对角线冲突
     * @param cc     右对角线冲突
     * @param result 结果集合
     */
    private static void  dfs(int i, int n, char[][] table, boolean[] ca, boolean[] cb, boolean[] cc, List<List<String>> result) {
        // 如果处理到第n行，结束递归
        if (i == n) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] chars : table) {
                list.add(String.valueOf(chars));
            }
            result.add(list);
            return;
        }
        // j 对应处理列 [i,j]对应皇后坐标
        for (int j = 0; j < n; j++) {
            // 如果当前皇后的坐标存在冲突，则跳出循环
            // 皇后坐标与左右斜线的对应关系：
            //          皇后坐标 [i,j]  ->  左斜线：i+j   右斜线：n-1-(i-j)
            if (ca[j] || cb[i + j] || cc[n - 1 - (i - j)]) {
                continue;
            }
            table[i][j] = 'Q'; // 在 [i,j] 位置放置皇后
            ca[j] = cb[i + j] = cc[n - 1 - (i - j)] = true; // 将列，左右对角线设置为冲突
            dfs(i + 1, n, table, ca, cb, cc, result); //递归
            table[i][j] = '.'; //回溯
            ca[j] = cb[i + j] = cc[n - 1 - (i - j)] = false; //回溯
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(8);
        System.out.println(lists);
    }

}
