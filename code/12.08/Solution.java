package cn.org.soloist.algorithm;

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
        int[] nums = {129, 17, 74, 57, 1421, 99, 92, 285, 1276, 218, 1588, 215, 369, 117, 153, 22};
        int k = 3;
        System.out.println(solution.canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (sum % k != 0) return false;

        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return divide(nums, visited, target, k, target, 0);
    }

    public static boolean divide(int[] nums, boolean[] visited, int target, int k, int temp, int index) {
        if (k == 0) return true;

        if (temp == 0) return divide(nums, visited, target, k - 1, target, 0);

        for (int i = index; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            if (temp >= nums[i] && divide(nums, visited, target, k, temp - nums[i], i + 1))
                return true;
            visited[i] = false;
        }

        return false;
    }
}
