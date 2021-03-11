package cn.org.soloist.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Soloist
 * @version 1.0
 * @create 2018/11/14 0:04
 * @email ly@soloist.top
 * @description
 */
public class Solution extends GuessGame {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {12,24,8,32};
        int[] B = {13,25,32,11};
        System.out.println(Arrays.toString(solution.advantageCount(A, B)));
    }

    public int[] advantageCount(int[] A, int[] B) {
        int[] C = B.clone();

        int[] temp = new int[A.length];
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0, j = 0, m = 0, n = A.length; i < A.length; i++) {
            if (A[i] > B[j]) {
                temp[m++] = A[i];
                j++;
            } else {
                temp[--n] = A[i];
            }
        }
        
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (B[i] == C[j]) {
                    res[j] = temp[i];
                    C[j] = -1;
                    break;
                }
            }
        }
        return res;
    }
}
