package com.dataStructure.dataStructure.queue;

import java.util.*;
import java.util.Queue;

class TreeNode {
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

/**
 * 二叉树的层序遍历
 */
public class E01Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 存储结果
        List<List<Integer>> result = new ArrayList<>();
        // 如果根节点为空，则直接返回结果
        if (root == null) {
            return result;
        }
        // 创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点放入队列
        queue.offer(root);
        // 记录每一层的节点个数
        int c1 = 1;//每一层节点个数
        // 当队列不为空时
        while (!queue.isEmpty()) {
            // 记录下一层节点个数
            int c2 = 0;//下一层节点个数
            // 创建一个存储每一层节点的列表
            List<Integer> lever = new ArrayList<>();
            // 遍历每一层节点
            for (int i = 0; i < c1; i++) {
                // 从队列中取出一个节点
                TreeNode node = queue.poll();
                // 将节点的值添加到列表中
                lever.add(node.val);
                // 如果该节点有左子节点，则将左子节点放入队列
                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }
                // 如果该节点有右子节点，则将右子节点放入队列
                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            // 更新每一层节点个数
            c1 = c2;
            // 将每一层节点列表添加到结果中
            result.add(lever);
        }
        // 返回结果
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int t = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int t2 = 0;//记录每层节点数
            List<Integer> lever = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                TreeNode node = queue.poll();
                lever.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    t2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    t2++;
                }
            }
            t = t2;
            result.add(lever);
        }
        return result;
    }

}
