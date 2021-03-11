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
        System.out.println(solution.largestPalindrome(2));
    }

    public int largestPalindrome(int n) {
        int high = (int) (Math.pow(10, n) - 1);
        int low = high / 10;

        for (int i = high; i > low; i--) {
            long res =  Long.parseLong(i + new StringBuilder().append(i).reverse().toString());
            for (long j = high; j * j > res; j--) {
                if (res % j == 0) return (int) (res % 1337);
            }
        }

        return 9;
    }
}
