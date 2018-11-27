package cn.org.soloist.algorithm;

import java.util.Arrays;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/11/14 0:04
 * @email ly@soloist.top
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] block = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int i1 = board[i][j] - '0';
                    row[i][i1] = true;
                    col[j][i1] = true;
                    block[i / 3 * 3 + j / 3][i1] = true;
                }
            }
        }

        dfs(board, row, col, block, 0, 0);
    }

    private boolean dfs(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {
        // 寻找空位
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }

            if (i >= 9) {
                return true;
            }
        }

        for (int k = 1; k <= 9; k++) {
            int index = i / 3 * 3 + j / 3;

            if (!row[i][k] && !col[j][k] && !block[index][k]) {
                board[i][j] = (char) ('0' + k);
                row[i][k] = true;
                col[j][k] = true;
                block[index][k] = true;
                // 递归
                if (dfs(board, row, col, block, i, j)) {
                    return true;
                } else {
                    // 回溯
                    board[i][j] = '.';
                    row[i][k] = false;
                    col[j][k] = false;
                    block[index][k] = false;
                }
            }
        }

        return false;
    }
}
