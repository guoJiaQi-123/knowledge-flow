package com.dataStructure.dataStructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 二叉树的最大深度<层序遍历>
 */
@SuppressWarnings("all")
public class E05Leetcode104_3 {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //二叉树的层序遍历需要用到队列数据结构
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //记录深度
        int depth = 0;
        while (!queue.isEmpty()) {
            //每一层节点个数<队列中元素个数记录的就是每一层节点的个数>
            int size = queue.size();
            //当前层有多少节点就循环多少次
            for (int i = 0; i < size; i++) {
                //就把多少节点从队列中弹出，并把它们的孩子加入队列
                TreeNode pollNode = queue.poll();
                if (pollNode.left != null) {
                    queue.offer(pollNode.left);
                }
                if (pollNode.right != null) {
                    queue.offer(pollNode.right);
                }
            }
            //每循环一层，层数 + 1
            depth++;
        }
        //当循环完所有节点，返回层数
        return depth;
    }


}
