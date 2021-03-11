package cn.org.soloist.algorithm;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/10/16 16:12
 * @email ly@soloist.top
 * @description
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Main main = new Main();
        System.out.println(Arrays.toString(main.twoSum(nums, target)));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sign = target - nums[i];
            if (map.containsKey(sign)) {
                return new int[]{map.get(sign), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
