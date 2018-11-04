package cn.org.soloist.algorithm;

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
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(main.search(nums, 3));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[left]) { // 左边有序
                if (nums[mid] > target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;
            } else { // 右边有序
                if (nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }
}
