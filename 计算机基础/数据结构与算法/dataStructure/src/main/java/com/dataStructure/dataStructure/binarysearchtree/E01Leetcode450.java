package com.dataStructure.dataStructure.binarysearchtree;

import com.dataStructure.dataStructure.binarytree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 */
public class E01Leetcode450 {



    /**
     * 递归法：
     *
     * @return 删除节点后剩下的节点
     */
    @SuppressWarnings("all")
    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
            return node;
        }
        if (node.val < key) {
            node.right = deleteNode(node.right, key);
            return node;
        }

        if (node.left == null) {//情况一：只有右孩子
            return node.right;
        }
        if (node.right == null) {//情况二：只有左孩子
            return node.left;
        }

        TreeNode s = node.right;
        while (s.left != null) {
            s = s.left;
        }
        s.right = deleteNode(node.right, s.val);
        s.left = node.left;
        return s;
    }

    /**
     * 非递归法
     */
    @SuppressWarnings("all")
    public TreeNode deleteNode2(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        //找待删除节点并且记录其父节点
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        //没找到待删除节点，直接返回根节点
        if (cur == null) {
            return root;
        }
        //找到待删除节点，分四种情况
        if (cur.left == null && cur.right == null) {
            cur = null;//情况一：待删除节点没有左右孩子，直接将待删除节点赋值为null
        } else if (cur.right == null) {
            cur = cur.left;//情况二：待删除节点只有左孩子没有右孩子
        } else if (cur.left == null) {
            cur = cur.right;//情况三：待删除节点只有右孩子没有左孩子
        } else {//情况四：待删除节点即有左孩子又有右孩子
            TreeNode successor = cur.right, successorParent = cur;
            //找待删除节点的后继节点并记录后继节点的父亲
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            //找到后继节点，分两种情况
            if (successorParent.val == cur.val) {
                //情况一：后继节点与待删除节点直接相邻
                successorParent.right = successor.right;
            } else {
                //情况二：后继节点与待删除节点不相邻
                successorParent.left = successor.right;
            }
            //将后继节点替换掉待删除节点实现删除
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        //如果待删除节点是根节点，没有父亲，则直接返回待删除节点
        if (curParent == null) {
            return cur;
        } else {
            //若待删除节点是其父亲节点的左孩子，则将已经删除完成的子树赋值给父亲的左孩子
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {//否则赋值给右孩子
                curParent.right = cur;
            }
            //返回根节点
            return root;
        }
    }
}

