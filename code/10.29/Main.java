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
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(main.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);

                        while (l < r && nums[l] == nums[++l]);
                        while (l < r && nums[r] == nums[--r]);

                        l++;
                        r--;
                     } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }

        return res;
    }
}
