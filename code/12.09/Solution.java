package cn.org.soloist.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/11/14 0:04
 * @email ly@soloist.top
 * @description
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] logs = {"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"};
        System.out.println(Arrays.toString(solution.reorderLogFiles(logs)));
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (o1, o2) -> {
            int i1 = o1.indexOf(' ');
            int i2 = o2.indexOf(' ');
            char c1 = o1.charAt(i1 + 1);
            char c2 = o2.charAt(i2 + 1);
            if (c1 >= 'a' && c2 >= 'a') {
                return o1.substring(i1).compareTo(o2.substring(i2));
            } else if (c1 >= 'a') {
                return -1;
            } else if (c2 >= 'a') {
                return 1;
            }

            return 0;
        });

        return logs;
    }
}
