package com.dataStructure.dataStructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
    ArrayList<TreeNode> pre = new ArrayList<>();
    ArrayList<TreeNode> mid = new ArrayList<>();
    ArrayList<TreeNode> last = new ArrayList<>();

    /**
     * 前中后序遍历
     */
    public void test(TreeNode root) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                pre.add(p);//前序
                stack.push(p);
                p = p.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null) {//没有右子树
                    mid.add(peek);//中序
                    pop = stack.pop();
                    last.add(pop);//后序
                } else if (peek.right == pop) {//右子树以及被处理
                    pop = stack.pop();
                    last.add(pop);//后序
                } else {
                    mid.add(peek);//中序
                    p = peek.right;
                }
            }
        }
    }
}
