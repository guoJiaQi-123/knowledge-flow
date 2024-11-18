package com.dataStructure.dataStructure.binarysearchtree;

import com.dataStructure.dataStructure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 判断是否为合法的二叉搜索树
 */
public class E04Leetcode98 {

    /**
     * 判断每个节点的上下限
     * 其中，父节点的左孩子的下限与父节点相同，上限为父节点的值
     *      父节点的右孩子的上限与父节点相同，下限为父节点的值
     *      如果有节点不符合上下限，则该二叉树不是二叉搜索树
     */
    public boolean isValidBST(TreeNode node) {
        return doValidBST(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean doValidBST(TreeNode node, long minValue, long maxValue) {
        if (node == null) {
            return true;
        }
        if (node.val >= maxValue || node.val <= minValue) {
            return false;
        }
        return doValidBST(node.left, minValue, node.val) && doValidBST(node.right, node.val, maxValue);
    }


    /**
     * 递归实现
     * 其中prev作为参数传入，注意：要传入对象类型的AtomicLong,否则prev作为局部变量，在递归方法中不起作用
     */
    public boolean isValidBST3(TreeNode node) {
        return doValidBST1(node, new AtomicLong(Long.MIN_VALUE));
    }

    private boolean doValidBST1(TreeNode node, AtomicLong prev) {
        if (node == null) {
            return true;
        }
        boolean a = doValidBST1(node.left, prev);
        if (!a) {
            return false;
        }
        if (prev.get() >= node.val) {
            return false;
        }
        prev.set(node.val);
        return doValidBST1(node.right, prev);
    }


    /**
     * 中序遍历，递归实现
     * 必须左右子树全都满足二叉搜索树才返回 true
     */
    long prev = Long.MIN_VALUE;

    public boolean isValidBST2(TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean a = isValidBST2(node.left);
        // 中序遍历
        if (!a) {
            return false;
        }
        //处理值
        if (prev >= node.val) {
            return false;
        }
        prev = node.val;
        return isValidBST2(node.right);
    }


    /**
     * 中序遍历 非递归
     * 如果中序遍历的结果集为升序的，则证明该树为二叉搜索树
     */
    public boolean isValidBST1(TreeNode root) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                if (prev >= pop.val) {
                    return false;
                }
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }
}
