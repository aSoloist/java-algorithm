package cn.org.soloist.algorithm;

import java.util.Arrays;
import java.util.Comparator;

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
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(solution.carFleet(target, position, speed));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        int res = 0;
        //建立位置-时间的N行2列的二维数组
        double[][] cars = new double[N][2];
        for (int i = 0; i < N; i++) {
            cars[i] = new double[]{position[i], (double) (target - position[i]) / speed[i]};
        }
        Arrays.sort(cars, Comparator.comparingDouble(o -> o[0]));
        double cur = 0;

        //从后往前比较
        for (int i = N - 1; i >= 0; i--) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }
        return res;
    }
}
