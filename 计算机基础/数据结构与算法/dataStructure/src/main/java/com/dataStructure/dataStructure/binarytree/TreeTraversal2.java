package com.dataStructure.dataStructure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树 前/中/后 遍历方式 三合一
 */
public class TreeTraversal2 {
    //存放前序遍历节点
    List<Integer> preOrder = new ArrayList<>();
    //存放中序遍历节点
    List<Integer> inOrder = new ArrayList<>();
    //存放后序遍历节点
    List<Integer> postOrder = new ArrayList<>();

    public void treeTraversal(TreeNode root) {
        //定义一个变量curr记录当前节点
        TreeNode curr = root;
        //定义一个栈数据结构，用来存放遍历过程中的节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        //定义一个变量pop用来存放最近被从栈中弹出的节点
        TreeNode pop = null;
        //当当前节点不为空，或者栈中有节点时，循环
        while (curr != null || !stack.isEmpty()) {
            //如果当前节点不为空
            if (curr != null) {
                preOrder.add(curr.val);//前序遍历
                //将当前节点放入栈中
                stack.push(curr);
                //将curr指向当前节点的左孩子
                curr = curr.left;
            } else {
                //获取栈中栈顶节点
                TreeNode peek = stack.peek();
                if (peek.right == null) {       // 情况一：右孩子为空
                    inOrder.add(peek.val);//中序遍历
                    pop = stack.pop();
                    postOrder.add(pop.val);//后序遍历
                } else if (peek.right == pop) { // 情况二：右孩子不为空，但左孩子已经处理完成
                    pop = stack.pop();
                    postOrder.add(pop.val);//后序遍历
                }else {                         // 情况三：右孩子不为空，而且也还没有处理
                    inOrder.add(peek.val);//中序遍历
                    curr = peek.right;
                }
            }
        }
    }

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

        TreeTraversal2 treeTraversal2 = new TreeTraversal2();
        treeTraversal2.treeTraversal(root);
    }
}
