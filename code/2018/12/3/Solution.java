package cn.org.soloist.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int[] nums = {5, 2, 2, 6, 1};
        System.out.println(solution.countSmaller(nums));
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        Integer[] res = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int left = 0, right = temp.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp.get(mid) >= nums[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = left;
            temp.add(left, nums[i]);
        }
        return Arrays.asList(res);
    }
}
