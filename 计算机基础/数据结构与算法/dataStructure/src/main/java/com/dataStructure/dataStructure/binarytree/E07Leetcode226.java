package com.dataStructure.dataStructure.binarytree;

/**
 * 反转二叉树
 */
public class E07Leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        //反转方法
        fn(root);
        return root;
    }

    private void fn(TreeNode node) {
        //结束递归条件：如果节点为空，返回
        if (node == null) {
            return;
        }
        //定义一个节点对象，用于充当中间过渡节点，先将左子树赋值给中间节点
        TreeNode t = node.left;
        //将右子树赋值给左子树节点
        node.left = node.right;
        //再将中间节点中存放的左子树赋值给右子树，完成根节点的左右子树反转
        node.right = t;
        //递归调用反转方法，将根节点的左孩子的孩子节点反转
        fn(node.left);
        //将根节点的右孩子的孩子节点反转
        fn(node.right);
    }
}