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
        int n = 2;
        int[][] p = {{1, 0}, {0, 1}};
        System.out.println(solution.canFinish(n, p));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        for (int[] prerequisite : prerequisites) {
            degree[prerequisite[1]]++;
            graph[prerequisite[0]].add(prerequisite[1]);
        }

        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (queue.size() != 0) {
            int course = queue.poll();
            for (int i = 0; i < graph[course].size(); i++) {
                int pointer = (int) graph[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.add(pointer);
                }
            }
        }

        for (int i : degree) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
