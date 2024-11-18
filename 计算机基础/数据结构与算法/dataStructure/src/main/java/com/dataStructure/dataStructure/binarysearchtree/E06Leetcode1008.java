package com.dataStructure.dataStructure.binarysearchtree;

import com.dataStructure.dataStructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历构造二叉搜索树
 */
public class E06Leetcode1008 {
    /**
     * 思路： 将前序遍历的第一个元素作为二叉搜索树的根节点
     * 遍历前序遍历数组，依次将从第二个开始的元素插入到以第一个元素为节点的二叉搜索树中
     */
    public TreeNode bstFromPreorder2(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            insert(root, preorder[i]);
        }
        return root;
    }

    /**
     * 向二叉搜索树中插入元素
     */
    private TreeNode insert(TreeNode node, int val) {
        //如果当前节点为空，说明找到空位置，返回以val为值的节点
        if (node == null) {
            return new TreeNode(val);
        }
        //如果当前值小于当前节点的值，递归调用插入方法，向当前节点的左子树中插入值
        if (node.val > val) {
            node.left = insert(node.left, val);
        }
        //如果当前值大于当前节点的值，递归调用插入方法，向当前节点的右子树中插入值
        if (node.val < val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    /**
     * 上限法              [ 8,5,1,7,10,12 ]
     * 思路：依次处理preorder中每个值, 返回创建好的节点或 null 作为上个节点的孩子
     * 1. 如果超过上限, 返回 null
     * 2. 如果没超过上限, 创建节点, 并将其左右孩子设置完整后返回
     * i++ 需要放在设置左右孩子之前，意思是从剩下的元素中挑选左右孩子
     */
    public TreeNode bstFromPreorder3(int[] preorder) {
        return insert(preorder, Integer.MAX_VALUE);
    }

    int i = 0;

    // 参数一：二叉搜索树的前序遍历数组   参数二：当前节点的上限
    public TreeNode insert(int[] preorder, int max) {
        if (i == preorder.length) {
            return null;
        }
        int val = preorder[i];
        if (val > max) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        i++;
        node.left = insert(preorder, val);
        node.right = insert(preorder, max);
        return node;
    }


    /**
     * 分治法：
     *   刚开始 8, 5, 1, 7, 10, 12，方法每次执行，确定本次的根节点和左右子树的分界线
     *   第一次确定根节点为 8，左子树 5, 1, 7，右子树 10, 12
     *   对 5, 1, 7 做递归操作，确定根节点是 5， 左子树是 1， 右子树是 7
     *   对 1 做递归操作，确定根节点是 1，左右子树为 null
     *   对 7 做递归操作，确定根节点是 7，左右子树为 null
     *   对 10, 12 做递归操作，确定根节点是 10，左子树为 null，右子树为 12
     *   对 12 做递归操作，确定根节点是 12，左右子树为 null
     *   递归结束，返回本范围内的根节点
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        return partition(preorder, 0, preorder.length - 1);
    }

    public TreeNode partition(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while (index <= end) {
            if (preorder[index] > preorder[start]) {
                break;
            }
            index++;
        }
        root.left = partition(preorder, start + 1, index - 1);
        root.right = partition(preorder, index, end);
        return root;
    }
}
