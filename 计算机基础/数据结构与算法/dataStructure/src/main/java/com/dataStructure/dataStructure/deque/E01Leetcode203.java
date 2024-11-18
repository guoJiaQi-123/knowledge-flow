package com.dataStructure.dataStructure.deque;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class E01Leetcode203 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //定义一个存放结果集的链表
        List<List<Integer>> result = new ArrayList<>();
        //如果根节点为空，则直接返回空结果集
        if (root == null) {
            return result;
        }
        //定义一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        //将根节点放入队列
        queue.offer(root);
        //记录每层节点个数
        int c = 1;
        //记录层数，以便对不同层做不同操作
        boolean odd = true;//默认为奇数层
        //如果队列非空
        while (!queue.isEmpty()) {
            //定义一个变量记录下一层节点个数
            int n = 0;
            //定义一个双端队列，用来存放每一层的节点
            Deque<Integer> lever = new LinkedList<>();
            //遍历当前层的每一个节点
            for (int i = 0; i < c; i++) {
                //将节点从队列中弹出
                TreeNode treeNode = queue.poll();
                if(odd){//如果为奇数层，则从尾部添加，正序
                   lever.offerLast(treeNode.val);
                }else {//如果是偶数层，则从头部添加，逆序
                    lever.offerFirst(treeNode.val);
                }
                //如果节点有左孩子，则加入队列
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                    n++;
                }
                //如果节点有右孩子，则加入队列
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                    n++;
                }
            }
            //将下一层节点数赋值给c
            c = n;
            //将每一层的节点组成的双端队列加入到结果集
            result.add(new LinkedList<>(lever));
            //层数取反，奇数层变偶数层    偶数层变奇数层
            odd=!odd;

        }
        return result;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
