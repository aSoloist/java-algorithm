package cn.org.soloist.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/10/16 16:12
 * @email ly@soloist.top
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 3, 2};
        main.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length - 2;
        while (len >= 0 && nums[len + 1] <= nums[len]) len--;
        if (len >= 0) {
            int swap = nums.length - 1;
            while (swap >= 0 && nums[swap] <= nums[len]) swap--;
            swap(nums, len, swap);
        }
        int end = nums.length;

        while (++len < --end) {
            swap(nums, len, end);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }
}
