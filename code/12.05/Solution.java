package cn.org.soloist.algorithm;

import java.util.*;

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
        System.out.println(solution.findNthDigit(1000000000));
    }


    public int findNthDigit(int n) {
        // 位数
        int len = 1;
        // 个数
        long size = 9;
        // 总数
        long count = len * size;
        while (count < n) {
            n -= count;
            len++;
            size *= 10;
        }
        // 位置
        int i = n / len, j = n % len;
        return j == 0 ? Integer.parseInt(("" + (int) (Math.pow(10, len - 1) + i - 1)).substring(len - 1)) : Integer.parseInt(("" + (int) (Math.pow(10, len - 1) + i)).substring(j - 1, j));
    }
}
