package cn.org.soloist.algorithm;

import java.util.Arrays;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/10/16 16:12
 * @email ly@soloist.top
 * @description 双指针法
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int i = main.removeElement(nums, val);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[length++] = nums[i];
            }
        }
        return length;
    }

}
