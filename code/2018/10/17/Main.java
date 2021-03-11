package cn.org.soloist.algorithm;

import java.util.Arrays;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/10/16 16:12
 * @email ly@soloist.top
 * @description
 */
public class Main {

    public static void main(String[] args) {
        int[] demo = {3, 1, 2, 4};
        Main main = new Main();
        int[] solution = main.solution(demo);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] demo) {
        int x = 0;
        int y = demo.length;
        int[] result = new int[y];

        for (int i : demo) {
            if (i % 2 == 0) {
                result[x++] = i;
            } else {
                result[--y] = i;
            }
        }

        return result;
    }

}
