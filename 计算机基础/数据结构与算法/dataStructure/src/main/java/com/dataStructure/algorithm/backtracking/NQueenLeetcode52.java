package com.dataStructure.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 52. N 皇后 II - 只返回存在情况的个数
 */
public class NQueenLeetcode52 {

    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] table = new char[n][n];
        for (char[] chars : table) {
            Arrays.fill(chars, '.');
        }
        boolean[] l = new boolean[n];
        boolean[] left = new boolean[2 * n - 1];
        boolean[] right = new boolean[2 * n - 1];
        dfs(0, n, l, left, right, table,result);
        return result.size();
    }

    public void dfs(int i, int n, boolean[] l, boolean[] left, boolean[] right, char[][] table,List<List<String>> result) {
        if (i == n) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] chars : table) {
                list.add(String.valueOf(chars));
            }
            result.add(list);
        }
        for (int j = 0; j < n; j++) {
            if (l[j] || left[i + j] || right[n - 1 - (i - j)]) {
                continue;
            }
            table[i][j] = 'Q';
            l[j] = left[i + j] = right[n - 1 - (i - j)] = true;
            dfs(i + 1, n, l, left, right, table,result);
            table[i][j] = '.';
            l[j] = left[i + j] = right[n - 1 - (i - j)] = false;
        }
    }
}
