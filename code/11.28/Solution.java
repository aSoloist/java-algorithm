package cn.org.soloist.algorithm;

import java.util.ArrayList;
import java.util.List;

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
        String S = "ababcbacadefegdehijhklij";
        System.out.println(solution.partitionLabels(S));
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] m = new int[26];

        for (int i = 0; i < S.length(); i++) {
            m[S.charAt(i) - 'a'] = i;
        }

        int a = 0, b = 0;
        for (int i = 0; i < S.length(); i++) {
            a = Math.max(a, m[S.charAt(i) - 'a']);
            if (i == a) {
                res.add(a - b + 1);
                b = a + 1;
            }
        }

        return res;
    }
}
