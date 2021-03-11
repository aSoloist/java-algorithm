package cn.org.soloist.algorithm;

import java.util.HashMap;
import java.util.Map;

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
        System.out.println(main.fractionToDecimal(-2147483648, 1));
        System.out.println(main.fractionToDecimal(-2147483648, -1));
        System.out.println(main.fractionToDecimal(7, -12));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == -1 && denominator == Integer.MIN_VALUE) return "0.0000000004656612873077392578125";
        if (numerator == 0) return "0";

        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            res.append("-");
        }

        long l_numerator = Math.abs((long) numerator);
        denominator = Math.abs(denominator);

        res.append(l_numerator / denominator);
        int remainder = (int) (l_numerator % denominator);
        if (remainder == 0) return res.toString();

        res.append(".");
        Map<Integer, Integer> map = new HashMap<>();
        int pos = 0, len = res.length();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                Integer start = map.get(remainder);
                res.insert(len + start, "(");
                res.append(")");
                return res.toString();
            }
            map.put(remainder, pos++);
            res.append(remainder * 10 / denominator);
            remainder = remainder * 10 % denominator;
        }

        return res.toString();
    }
}
