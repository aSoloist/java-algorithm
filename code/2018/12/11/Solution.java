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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        distToTarget(root, target, K, res);
        return res;
    }

    public int distToTarget(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null) return -1;
        if (root == target) {
            getChildrenDistK(target, 0, K, res);
            return 1;
        }
        int left = distToTarget(root.left, target, K, res);
        int right = distToTarget(root.right, target, K, res);
        if (left > 0) {
            if (left == K) res.add(root.val);
            getChildrenDistK(root.right, left, K - 1, res);
            return left + 1;
        }
        if (right > 0) {
            if (right == K) res.add(root.val);
            getChildrenDistK(root.left, right, K - 1, res);
            return right + 1;
        }
        return -1;
    }

    public void getChildrenDistK(TreeNode root, int level, int K, List<Integer> res) {
        if (level > K || root == null) return;
        if (level == K) {
            res.add(root.val);
            return;
        }
        getChildrenDistK(root.left, level + 1, K, res);
        getChildrenDistK(root.right, level + 1, K, res);
    }
}
