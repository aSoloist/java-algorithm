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
        System.out.println(main.reverseNumber(12321));
    }

    public boolean reverseNumber(int num) {
        // 负数与10的倍数必定为false
        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        int reverseNumber = 0;
        while (num > reverseNumber) {
            reverseNumber = reverseNumber * 10 + num % 10;
            num /= 10;
        }

        return num == reverseNumber || num == reverseNumber / 10;
    }

}
