package cn.org.soloist.algorithm;

import java.util.HashMap;
import java.util.Map;

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
        int[] nums = {1, 1, 1};
        int k = 3;
        System.out.println(main.subarraySum(nums, k));
    }

    public int subarraySum(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
