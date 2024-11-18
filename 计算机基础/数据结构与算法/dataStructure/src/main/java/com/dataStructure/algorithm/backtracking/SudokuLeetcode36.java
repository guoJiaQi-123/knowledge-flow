package com.dataStructure.algorithm.backtracking;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 36. 有效的数独
 */
public class SudokuLeetcode36 {
    public boolean isValidSudoku(char[][] board) {
        // 存储冲突的数组
        boolean[][] ca = new boolean[9][9]; // 行冲突
        // ca[0] = [false,false,true,false,true,false,true,false,false]
        boolean[][] cb = new boolean[9][9]; // 列冲突
        boolean[][] cc = new boolean[9][9]; // 九宫格冲突
        // 初始化冲突数组
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j]; // 遍历每一个字符
                if (c != '.') { // 如果字符不为'.'
                    boolean b = cc[i / 3 * 3 + j / 3][c - '1']; // 九宫格冲突
                    // 如果当前字符不为'.',但是对应的行，列，九宫格中已经存在当前数字,则返回false
                    if (ca[i][c - '1'] || cb[j][c - '1'] || b) {
                        return false;
                    }
                    // 如果不存在，则更新冲突数组
                    ca[i][c - '1'] = true; // 将其所在行的数字c设置为冲突(该行不能再添加c数字)
                    cb[j][c - '1'] = true; // 将其所在列的数字c设置为冲突(该列不能再添加c数字)
                    b = true;// 将其所在九宫格的数字c设置为冲突(该九宫格不能再添加c数字)
                }
            }
        }
        // 遍历完所有字符，没有冲突，返回true
        return true;
    }
}
