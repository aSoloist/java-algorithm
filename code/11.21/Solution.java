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
        int[] nums = {1, 5, 10};
        int n = 20;
        System.out.println(solution.minPatches(nums, n));
    }

    public int minPatches(int[] nums, int n) {
        int i = 0, res = 0, len = nums.length;
        long max = 0;
        while (max < n) {
            if (i < len && nums[i] <= max + 1) {
                max += nums[i++];
            } else {
                max += max + 1;
                res++;
            }
        }

        return res;
    }
}
