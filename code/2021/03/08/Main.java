package cn.org.soloist.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author soloist
 * @version 1.0
 * @create 2021/3/8 22:14
 * @email soloist1511@gmail.com
 * @description
 */
public class Main {

    public static void main(String[] args) {
        String s = "aab";
        Solution solution = new Solution();
        List<List<String>> partition = solution.partition(s);
        System.out.println(partition);
    }

}

class Solution {

    boolean[][] isHui;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<>();
    int len;

    public List<List<String>> partition(String s) {
        len = s.length();
        isHui = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(isHui[i], true);
        }

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                isHui[i][j] = (s.charAt(i) == s.charAt(j)) && isHui[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == len) {
            ret.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < len; ++j) {
            if (isHui[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

}
