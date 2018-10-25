package cn.org.soloist.algorithm;

import java.util.Arrays;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/10/16 16:12
 * @email ly@soloist.top
 * @description 经典二分查找算法
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 3, 5, 6};
        int target = 4;
        System.out.println(main.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = (left + right) >>> 1;
            int num = nums[middle];

            if (num > target) {
                right = middle - 1;
            } else if (num < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return left;
    }

    private int searchInsert(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }

        int middle = (left + right) >>> 1;
        if (nums[middle] == target) {
            return middle;
        }

        if (nums[middle] < target) {
            return searchInsert(nums, target, middle + 1, right);
        } else {
            return searchInsert(nums, target, left, middle - 1);
        }
    }
}
