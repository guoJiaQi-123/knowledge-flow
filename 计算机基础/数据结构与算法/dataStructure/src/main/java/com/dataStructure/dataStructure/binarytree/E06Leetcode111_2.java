package com.dataStructure.dataStructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度<b><层序遍历></b>
 */
@SuppressWarnings("all")
public class E06Leetcode111_2 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        //思想：使用层序遍历，当遍历到第一个叶子节点，他所在的层就是最小深度
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int Depth = 0;
        while (!queue.isEmpty()) {
            Depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                //判断是否是叶子节点
                if(poll.right==null&&poll.left==null){
                    //如果是，则直接返回当前节点的层数即为深度
                    return Depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return Depth;
    }
}
