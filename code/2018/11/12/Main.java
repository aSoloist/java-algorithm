package cn.org.soloist.algorithm;

import java.util.*;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/10/16 16:12
 * @email ly@soloist.top
 * @description
 */
public class Main {

    private int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    private String target = "123450";

    class Idx {
        int x;
        int y;
        int count;
        String board;

        Idx(int x, int y, int count, String board) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.board = board;
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(main.slidingPuzzle(board));
    }

    public String swap(String board, int x, int y, int nx, int ny, int len) {
        StringBuilder stringBuilder = new StringBuilder(board);
        int zero = x * len + y; // 0的位置
        int pos = nx * len + ny; // 移动位置
        // 替换两个数字
        String s1 = stringBuilder.substring(pos, pos + 1);
        String s2 = stringBuilder.substring(zero, zero + 1);
        stringBuilder.replace(zero, zero + 1, s1);
        stringBuilder.replace(pos, pos + 1, s2);
        return stringBuilder.toString();
    }

    public int slidingPuzzle(int[][] board) {
        Set<String> visited = new HashSet<>();
        Queue<Idx> queue = new LinkedList<>();

        StringBuilder stringBuilder = new StringBuilder();
        // 初始化
        int x = 0, y = 0, m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append(board[i][j]);
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }
        visited.add(stringBuilder.toString());
        queue.add(new Idx(x, y, 0, stringBuilder.toString()));
        // bfs
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Idx poll = queue.poll();
                if (poll.board.equals(target)) return poll.count;

                for (int[] ints : dirs) {
                    x = poll.x + ints[0];
                    y = poll.y + ints[1];
                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        String swap = swap(poll.board, poll.x, poll.y, x, y, n);
                        if (!visited.contains(swap)) {
                            queue.add(new Idx(x, y, poll.count + 1, swap));
                            visited.add(swap);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
