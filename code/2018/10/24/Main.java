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
        String[] strs = {"aca", "cba"};
        System.out.println(main.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 最短字符串
        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            length = Math.min(length,  strs[i].length());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char sign = strs[0].charAt(i);
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                char c = strs[j].charAt(i);
                if (c != sign) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                stringBuilder.append(sign);
            } else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
