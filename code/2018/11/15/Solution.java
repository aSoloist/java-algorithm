package cn.org.soloist.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        System.out.println(solution.reorderedPowerOf2(46));
    }

    private static Set<String> set = new HashSet<>();
    // 初始化
    static {
        int n = 1;
        while (n < 1000000000) {
            String s = String.valueOf(n);
            int[] nums = new int[10];
            for (char c : s.toCharArray()) {
                nums[c - '0']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : nums) stringBuilder.append(i);
            set.add(stringBuilder.toString());
            n <<= 1;
        }
    }

    public boolean reorderedPowerOf2(int N) {
        String s = String.valueOf(N);
        int[] res = new int[10];
        for (char c : s.toCharArray()) {
            res[c - '0']++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : res) stringBuilder.append(i);

        return set.contains(stringBuilder.toString());
    }

}
