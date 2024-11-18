package com.dataStructure.dataStructure.binarytree;


import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class E02Leetcode94 {
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
        inOrder(root);

    }

    /**
     * 中序遍历
     */
    public static void inOrder(TreeNode root) {
        //先定义一个变量存放当前节点
        TreeNode curr = root;
        //定义一个栈数据结构，用来存放遍历过程中的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        //当左孩子不为空或者栈中不为空，则循环
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                //如果当前节点不为空，将其放入栈中
                stack.push(curr);
                //将curr指向当前节点的左孩子
                curr = curr.left;
            } else {
                //如果当前节点为空了，则从栈中弹出节点并输出（说明被弹栈节点左孩子为空）
                TreeNode pop = stack.pop();
                System.out.println(pop);
                //将curr指向当前节点的右孩子
                curr = pop.right;
            }
        }
    }

    /**
     * 中序遍历
     */
    static class Solution {
        /**
         * 中序遍历
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            TreeNode curr = root;//定义一个变量，存放当前节点
            List<Integer> inOrder = new LinkedList<>();
            LinkedList<TreeNode> stack = new LinkedList<>();
            //当前节点不为空且栈不为空
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    TreeNode pop = stack.pop();
                    inOrder.add(pop.val);
                    curr = pop.right;
                }
            }
            return inOrder;
        }
    }


    /*
        31 红
        32 黄
        33 橙
        34 蓝
        35 紫
        36 绿
     */
    public static void colorPrintln(String origin, int color) {
        System.out.printf("\033[%dm%s\033[0m%n", color, origin);
    }
}
