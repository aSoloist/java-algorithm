package cn.org.soloist.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(Arrays.toString(solution.findMode(root)));
    }

    private TreeNode pre = null;
    private int cou = 1;
    private int max = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        inorder(root, list);
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) return;

        inorder(node.left, res);

        if (pre != null) {
            cou = pre.val == node.val ? cou + 1 : 1;
        }

        if (cou > max) {
            res.clear();
            res.add(node.val);
            max = cou;
        } else if (cou == max) {
            res.add(node.val);
        }

        pre = node;

        inorder(node.right, res);
    }

}
