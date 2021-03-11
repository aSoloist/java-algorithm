package cn.org.soloist.algorithm;

import java.util.Stack;

/**
 * @author soloist
 * @version 1.0
 * @create 2021/3/11 10:59
 * @email soloist1511@gmail.com
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("-((1+(4+5+2)-3)+(6+8))"));
    }

}

class Solution {

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Integer> signs = new Stack<>();
        char[] chars = s.toCharArray();
        int len = s.length();
        int sign = 1;
        int ret = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (c == ' ') continue;
            if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c <= '9' && c >= '0') {
                long num = c - '0';
                while (i < len - 1 && chars[i + 1] <= '9' && chars[i + 1] >= '0') {
                    num = num * 10 + chars[++i] - '0';
                }
                ret += num * sign;
            } else if (c == '(') {
                nums.push(ret);
                signs.push(sign);
                ret = 0;
                sign = 1;
            } else if (c == ')') {
                ret = nums.pop() + signs.pop() * ret;
            }
        }
        return ret;
    }

}
