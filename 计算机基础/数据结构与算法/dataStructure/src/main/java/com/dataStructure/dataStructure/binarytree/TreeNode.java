package com.dataStructure.dataStructure.binarytree;

/**
 * <h3>树节点类</h3>
 */
public class TreeNode {

    public TreeNode left;
    public Integer val;
    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, Integer val, TreeNode right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
