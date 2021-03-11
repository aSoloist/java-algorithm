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
        System.out.println(main.reverseNumber(-12321));
        System.out.println(main.reverseNumber(0));
        System.out.println(main.reverseNumber(1221));
    }

    public boolean reverseNumber(int x) {
        if (x < 0) {
            return false;
        }

        int reverseNumber = 0;
        int origin = x;
        while (x > 0) {
            reverseNumber = reverseNumber * 10 + x % 10;
            x /= 10;
        }

        return origin == reverseNumber;
    }

}
