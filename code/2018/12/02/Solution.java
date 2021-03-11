package cn.org.soloist.algorithm;

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
        System.out.println(solution.numSquares(9997));
    }

    public int numSquares(int n) {
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;

        for (int i = 0; i * i < n; i++) {
            int a = (int) Math.sqrt(n - i * i);
            if (i * i + a * a == n) {
                return i == 0 ? 1 : 2;
            }
        }

        return 3;
    }
}
