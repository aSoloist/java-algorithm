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
        String str[][] = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        System.out.println(solution.findItinerary(str));
    }


    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (String[] s : tickets) {
            map.putIfAbsent(s[0], new PriorityQueue<>());
            map.get(s[0]).add(s[1]);
        }

        dfs("JFK", map, res);
        return res;
    }

    private void dfs(String s, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> strings = map.get(s);
        while (strings != null && !strings.isEmpty()) {
            dfs(strings.poll(), map, res);
        }

        res.addFirst(s);
    }
}
