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
        int minLower = 'a';
        int maxLower = 'z';
        int length = minLower - 'A';
        String str = "This Is A Test";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= maxLower && chars[i] >= minLower) {
                chars[i] = (char) (chars[i] - length);
            }
        }

        System.out.println(String.valueOf(chars));
    }

}
