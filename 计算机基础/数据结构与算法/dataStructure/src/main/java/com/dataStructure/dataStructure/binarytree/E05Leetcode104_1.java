package com.dataStructure.dataStructure.binarytree;

/**
 * 求树的最大深度<后序遍历-递归>
 */
public class E05Leetcode104_1 {

    /*
    思路：
    1. 得到左子树深度, 得到右子树深度, 二者最大者加一, 就是本节点深度
    2. 因为需要先得到左右子树深度, 很显然是后序遍历典型应用
    3. 关于深度的定义：从根出发, 离根最远的节点总边数,
        注意: 力扣里的深度定义要多一

        深度2         深度3         深度1
        1            1            1
       / \          / \
      2   3        2   3
                        \
                         4
    */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        //得到左子树深度
        int maxLeft = maxDepth(root.left);
        //得到右子树深度
        int maxRight = maxDepth(root.right);
        //二者最大者加一, 就是本节点深度
        return Integer.max(maxLeft, maxRight) + 1;
    }
}
