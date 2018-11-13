package cn.org.soloist.algorithm;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/11/14 0:04
 * @email ly@soloist.top
 * @description
 */
public class Solution extends GuessGame {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMoneyAmount(8));
    }

    public int getMoneyAmount(int n) {
        // dp[i][j]表示从i到j之间猜测数字至少要拥有的钱数
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 2; i < dp.length; i++) { // 2-n
            for (int j = i - 1; j > 0; j--) { // 1-i
                int min = Integer.MAX_VALUE;
                for (int k = j; k < i; k++) { // 局部较大值，全局较小值
                    // j到i可以通过k分成三部分：j到k-1、k、k+1到i，则猜测k（假设未中），
                    // 加上dp[j][k -1]和dp[k + 1][i]之间的较大值，为本轮至少要拥有的钱数，
                    // 通过min记录j到i所有可能中最小的结果，并使dp[j][i] = min；
                    min = Math.min(min, k + Math.max(dp[j][k - 1], dp[k + 1][i]));
                }
                dp[j][i] = min;
            }
        }

        return dp[1][n];
    }

}
