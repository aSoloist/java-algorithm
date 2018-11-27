package cn.org.soloist.algorithm;

import java.util.*;

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
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(solution.minMutation(start, end, bank));
    }

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> s = new HashSet<>(Arrays.asList(bank));
        if (!s.contains(end)) return -1;
        // 初始化
        char[] chars = {'A', 'C', 'G', 'T'};
        Map<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            String poll = queue.poll();
            int res = visited.get(poll);

            for (int i = 0; i < poll.length(); i++) {
                char[] charArray = poll.toCharArray();
                for (char c : chars) {
                    if (charArray[i] == c) continue;

                    charArray[i] = c;
                    String check = new String(charArray);

                    if (check.equals(end)) return res + 1;

                    if (s.contains(check) && !visited.containsKey(check)) {
                        visited.put(check, res + 1);
                        queue.offer(check);
                    }
                }
            }
        }

        return -1;
    }
}
