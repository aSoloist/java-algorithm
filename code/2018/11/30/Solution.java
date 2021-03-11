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
        System.out.println(solution.nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int i2 = 1, i3 = 1, i5 = 1;
        int k2 = 2, k3 = 3, k5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(k2, Math.min(k3, k5));
            res[i] = min;

            if (min == k2) {
                k2 = res[i2] * 2;
                i2++;
            }

            if (min == k3) {
                k3 = res[i3] * 3;
                i3++;
            }

            if (min == k5) {
                k5 = res[i5] * 5;
                i5++;
            }
        }

        return res[n - 1];
    }
}
