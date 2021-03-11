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
        int dividend = -2147483648, divisor = 2;
        System.out.println(main.divide(dividend, divisor));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long m = dividend, n = divisor;
        m = Math.abs(m);
        n = Math.abs(n);

        int flag = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        if (m == 0 || n == 1) return (int) (flag * m);

        int res = 0;
        while (m >= n) {
            long k = n, temp = 1;

            while (m >= k << 1) {
                k <<= 1;
                temp <<= 1;
            }

            m -= k;
            res += temp;
        }

        return res * flag;
    }
}
