package cn.org.soloist.algorithm;

import java.util.Arrays;

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
        int[] nums = {1, 2, 3, 4, 5};
        int[] ints = main.productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] n1 = new int[len]; // 从左到右
        int[] n2 = new int[len]; // 从右到左
        n1[0] = nums[0];
        n2[0] = nums[len - 1];
        for (int i = 1; i < len; i++) {
            n1[i] = nums[i] * n1[i - 1];
            n2[i] = nums[len - 1 - i] * n2[i - 1];
        }

        int[] res = new int[len];
        res[0] = n2[len - 2];
        res[len - 1] = n1[len - 2];
        for (int i = 1; i < len - 1; i++) {
            res[i] = n1[i - 1] * n2[len - i - 2];
        }
        return res;
    }
}
