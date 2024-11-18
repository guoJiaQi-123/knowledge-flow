package com.dataStructure.dataStructure.binarytree;

import java.util.LinkedList;

/**
 * 求二叉树的最大深度<后序遍历-非递归>
 */
public class E05Leetcode104_2 {
    public int maxDepth(TreeNode root) {
        TreeNode curr = root;
        //非递归方法遍历树需要栈数据结构
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;
        int max = 0;//记录最大深度
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                //在向栈中添加元素后，栈中元素个数发生改变，栈中最大元素个数就是树的最大深度
                int size = stack.size();
                //如果栈中元素个数大于max，则更新max
                if (size > max) {
                    max = size;
                }
                curr = curr.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop) {
                    pop = stack.pop();
                } else {
                    curr = peek.right;
                }
            }
        }
        return max;
    }
}
