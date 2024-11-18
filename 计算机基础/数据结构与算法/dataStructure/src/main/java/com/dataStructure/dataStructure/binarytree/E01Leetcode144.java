package com.dataStructure.dataStructure.binarytree;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class E01Leetcode144 {
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        preOrder(root);

    }

    /**
     * 前序遍历
     */
    public static void preOrder(TreeNode root) {
        //定义一个变量，存放当前节点
        TreeNode curr = root;
        //定义一个栈数据结构，用来存放遍历过程中的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        //当左孩子不为空或者栈中不为空，则循环
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                //如果当前节点不为空,打印
                System.out.println(curr);
                //打印后将该节点放入栈中
                stack.push(curr);
                //将curr指向当前节点的左孩子
                curr = curr.left;
            } else {
                //如果当前节点为空，则从栈中弹出节点
                TreeNode pop = stack.pop();
                //将curr指向弹出节点的右孩子（此时当前节点的所有左孩子和当前节点以及全部打印）
                curr = pop.right;
            }
        }
    }

    /**
     * 前序遍历
     */
    static class Solution {
        /**
         * 前序遍历
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            TreeNode curr = root;//定义一个变量，存放当前节点
            List<Integer> preOrder = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            //当前节点不为空且栈不为空
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    preOrder.add(curr.val);
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    TreeNode pop = stack.pop();
                    curr = pop.right;
                }
            }
            return preOrder;
        }
    }


    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}
