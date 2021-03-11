package cn.org.soloist.algorithm;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/11/14 0:04
 * @email ly@soloist.top
 * @description
 */
public class Solution extends GuessGame {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("3+2*2-3"));
    }

    public int calculate(String s) {
        int res = 0, curRes = 0, num = 0, len = s.length();

        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }

            if (c == '+' || c == '-' || c == '*' || c == '/' || i == len - 1) {
                switch (sign) {
                    case '+':
                        curRes += num;
                        break;
                    case '-':
                        curRes -= num;
                        break;
                    case '*':
                        curRes *= num;
                        break;
                    case '/':
                        curRes /= num;
                        break;
                }
                if (c == '+' || c == '-' || i == len - 1) {
                    res += curRes;
                    curRes = 0;
                }
                sign = c;
                num = 0;
            }
        }

        return res;
    }
}
