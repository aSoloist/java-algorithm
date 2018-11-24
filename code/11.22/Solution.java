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
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums));
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strs.length == 0 || strs[0].equals("0")) return "0";

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs) stringBuilder.append(s);

        return stringBuilder.toString();
    }
}
