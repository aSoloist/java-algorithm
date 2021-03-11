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
        int[] answers = {10, 10, 10};
        System.out.println(main.numRabbits(answers));
    }

    public int numRabbits(int[] answers) {
        int[] rabbits = new int[1000];
        int res = 0;

        for (int i : answers) {
            if (rabbits[i] == 0) {
                res += i + 1;
                rabbits[i] = i;
            } else {
                rabbits[i]--;
            }
        }

        return res;
    }
}
