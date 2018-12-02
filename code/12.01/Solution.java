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
        int[] primes = {2, 7, 13, 19};
        int n = 12;
        System.out.println(solution.nthSuperUglyNumber(n, primes));
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;

        int len = primes.length;
        int[] index = new int[len];
        int[] key = Arrays.copyOf(primes, len);

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min = Math.min(min, key[j]);
            }

            res[i] = min;

            for (int j = 0; j < len; j++) {
                if (min == key[j]) {
                    index[j]++;
                    key[j] = res[index[j]] * primes[j];
                }
            }
        }

        return res[n - 1];
    }

}
