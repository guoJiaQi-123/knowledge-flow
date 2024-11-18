package com.dataStructure.dataStructure.binarytree;


import java.util.Arrays;

/**
 * 从前序与中序遍历序列构造二叉树
 */
public class E09Leetcode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /*

            输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
             输出: [3,9,20,null,null,15,7]

        */
        //结束递归的条件：当遍历数组为空时，说明已经没有值，返回空
        if (preorder.length == 0) {
            return null;
        }

        // 前序遍历的第一个值一定是根节点的值
        int rootValue = preorder[0];
        //创建根节点
        TreeNode root = new TreeNode(rootValue);
        //遍历中序数组
        for (int i = 0; i < inorder.length; i++) {
            //在中序数组中要找根节点所在位置
            if (inorder[i] == rootValue) {
                //以根节点为中心，将中序数组分为左部分和右部分，其中左部分即为根节点左子树的中序遍历数组
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                //右部分即为根节点右子树的中序遍历数组
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                //通过中序遍历数组左右部分的个数，右可以将前序数组从第二个值开始分为左部分和右部分
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, inorder.length);

                //分别把前序数组左部分和中序数组左部分，以及前序数组右部分和中序数组右部分看做一颗数的前序遍历和中序遍历
                //递归调用buildTree方法返回根节点作为上一次返回根的左子树节点以及右子树节点
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);

                // ** 切记！！ 在中序遍历数组中找到根的值后要跳出循环
                break;
            }
        }
        //返回根节点
        return root;
    }
}
