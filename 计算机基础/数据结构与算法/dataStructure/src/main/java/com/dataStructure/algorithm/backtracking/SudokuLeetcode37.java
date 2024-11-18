package com.dataStructure.algorithm.backtracking;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 37. 解数独
 */
public class SudokuLeetcode37 {
    public void solveSudoku(char[][] board) {
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
                    ca[i][c - '1'] = true; // 将其所在行的数字c设置为冲突(该行不能再添加c数字)
                    cb[j][c - '1'] = true; // 将其所在列的数字c设置为冲突(该列不能再添加c数字)
                    cc[i / 3 * 3 + j / 3][c - '1'] = true;// 将其所在九宫格的数字c设置为冲突(该九宫格不能再添加c数字)
                }
            }
        }
        dfs(0, 0, board, ca, cb, cc);
    }

    /**
     * 递归方法
     * @param i 正在处理的行
     * @param j 正在处理的列
     * @param board 整个二维数组
     * @param ca 处理列冲突数组
     * @param cb 处理行冲突数组
     * @param cc 处理九宫格冲突数组
     * @return 是否找到解
     */
    private boolean dfs(int i, int j, char[][] board, boolean[][] ca, boolean[][] cb, boolean[][] cc) {
        while (board[i][j] != '.') {
            // 超出列长，则列长恢复为0，行++
            if (++j >= 9) {
                j = 0;
                i++;
            }
            // i>=9 说明已经遍历的所有数组中的元素
            if (i >= 9) {
                return true;
            }
        }
        // 向没有添加数字的节点尝试添加 1 - 9
        for (int x = 1; x <= 9; x++) {
            // 如果添加的数字x在当前行，当前列，当前九宫格中有任意一个冲突，则跳过，尝试下一个数字
            if (ca[i][x - 1] || cb[j][x - 1] || cc[i / 3 * 3 + j / 3][x - 1]) {
                continue;
            }
            // 如果没有冲突，向[i,j]节点添加x数字
            board[i][j] = (char) (x + '0');
            // 添加完数字后，更新冲突数组，把当前行，当前列，当前九宫格中的x-1设置为true
            ca[i][x - 1] = cb[j][x - 1] = cc[i / 3 * 3 + j / 3][x - 1] = true;
            boolean dfs = dfs(i, j, board, ca, cb, cc); // 递归
            if (dfs) {
                return true; // 如果找到解，则直接返回true
            }
            board[i][j] = '.'; // 如果没找到解，回溯
            ca[i][x - 1] = cb[j][x - 1] = cc[i / 3 * 3 + j / 3][x - 1] = false; //回溯
        }
        return false;
    }
}
