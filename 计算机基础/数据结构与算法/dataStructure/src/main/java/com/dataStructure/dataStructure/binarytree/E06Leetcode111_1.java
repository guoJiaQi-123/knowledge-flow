package com.dataStructure.dataStructure.binarytree;

/**
 * 二叉树的最小深度<b><递归></b>
 */
public class E06Leetcode111_1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (minRight == 0) {
            return minLeft + 1;
        }
        if (minLeft == 0) {
            return minRight + 1;
        }
        return Integer.min(minLeft, minRight) + 1;
    }
}
