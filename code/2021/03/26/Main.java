package cn.org.soloist.algorithm;

/**
 * 2021/3/26 09:50
 *
 * @author soloist<soloist1511@gmail.com>
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(solution.majorityElement(nums));
    }

}

class Solution {

    public int majorityElement(int[] nums) {
        int count = 0;
        int max = nums[0];

        for (int num : nums) {
            if (num == max) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                max = num;
                count++;
            }
        }

        return max;
    }

}
