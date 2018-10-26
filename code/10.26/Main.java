package cn.org.soloist.algorithm;

import java.util.Arrays;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/10/16 16:12
 * @email ly@soloist.top
 * @description 双指针法
 * 使用两个指针，一个放在开始，一个放在结尾，先计算最外围两个线段构成的面积，然后不断将较短线段的指针向较长线段移动，保留最大面积。
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(main.maxArea(nums));
    }

    public int maxArea(int[] height) {
        int area = 0, l = 0, r = height.length - 1;
        while (l < r) {
            area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return area;
    }
}
