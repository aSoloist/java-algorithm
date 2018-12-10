package cn.org.soloist.algorithm;

import java.util.Arrays;

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
        ListNode node = solution.array2Node(new int[]{1, 2, 3, 4, 5, 6});
        int k = 5;
        System.out.println(Arrays.toString(solution.splitListToParts(node, k)));
    }

    private ListNode array2Node(int[] arr) {
        ListNode root = new ListNode(0);
        ListNode res = root;
        for (int i : arr) {
            root.next = new ListNode(i);
            root = root.next;
        }

        return res.next;
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] listNodes = new ListNode[k];
        int N = 0;
        ListNode temp = root;
        while (temp != null) {
            N++;
            temp = temp.next;
        }

        int size = N / k;
        int add = N % k;

        temp = root;
        for (int i = 0; i < k && temp != null; i++) {
            listNodes[i] = temp;
            int len = size + (add-- > 0 ? 1 : 0);
            for (int j = 0; j < len - 1; j++) {
                temp = temp.next;
            }

            if (temp != null) {
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
            }
        }

        return listNodes;
    }
}
