package cn.org.soloist.algorithm;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/10/16 16:12
 * @email ly@soloist.top
 * @description
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int i = sc.nextInt();
        System.out.println(solution(i));
    }

    public static Integer solution(Integer num) {
        return num.toString().length();
    }

}
