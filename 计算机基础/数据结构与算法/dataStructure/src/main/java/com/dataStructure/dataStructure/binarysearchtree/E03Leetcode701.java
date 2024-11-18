package com.dataStructure.dataStructure.binarysearchtree;

import com.dataStructure.dataStructure.binarytree.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 */
public class E03Leetcode701 {



    /**
     * 递归法
     *
     * @return 插入后的根节点
     */
    @SuppressWarnings("all")
    public TreeNode insertIntoBST(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertIntoBST(node.left, val);
        }
        if (val > node.val) {
            node.right = insertIntoBST(node.right, val);
        }
        return node;
    }


    /**
     * 非递归
     */
    @SuppressWarnings("all")
    public TreeNode insertIntoBST2(TreeNode node, int val) {
        //如果根节点为空，则直接返回一个插入的新节点
        if (node == null) {
            return new TreeNode(val);
        }
        TreeNode p = node;
        TreeNode parent = null;
        //查找插入节点的合适位置并记录其父节点
        while (p != null) {
            if (val < p.val) {
                parent = p;
                p = p.left;
            } else if (val > p.val) {
                parent = p;
                p = p.right;
            } else {
                //找到树中原本存在值为val的节点，替换该节点的值
                p.val = val;
                break;
            }
        }
        //如果待插入节点的val小于父亲节点的val，则待插入节点应该做父亲节点的左孩子
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {//否则做父亲节点的右孩子
            parent.right = new TreeNode(val);
        }
        return node;
    }
}
