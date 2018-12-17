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
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        solution.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        for (int i = nums.length - k - 1; i >= 0; i--) {
            int start = i;
            int temp = nums[start];
            for (int j = i + 1; j <= i + k; j++) {
                nums[start] = nums[++start];
            }
            nums[start] = temp;
        }
    }

    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        int n = k % len;

        reverse(nums, 0, len - n - 1);
        reverse(nums, len - n, len - 1);
        reverse(nums, 0, len - 1);
    }

    private void reverse(int[] nums, int n, int m) {
        for (int i = n, j = m; i <= j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
