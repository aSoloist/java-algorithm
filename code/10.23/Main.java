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
        int i = main.myAtoi("-+1");
        System.out.println(i);
    }

    public int myAtoi(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }

        int flag = 1;
        int num = 0;
        int i = 0;
        if (chars[i] == '-' || chars[i] == '+') {
            flag = chars[i++] == '-' ? -1 : 1;
        }

        while (i < chars.length && chars[i] >= '0' && chars[i] <= '9') {
            if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && chars[i] - '0' > 7)) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + chars[i++] - '0';
        }

        return flag * num;
    }
}
