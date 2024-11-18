package com.dataStructure.dataStructure.binarysearchtree;

import com.dataStructure.dataStructure.binarytree.TreeNode;

/**
 * 	700.二叉搜索树中的搜索
 */
public class E02Leetcode700 {


    @SuppressWarnings("all")
    /**
     * 递归
     */
    public TreeNode searchBST(TreeNode node, int val) {

        if(node ==null) {
            return null;
        }

        if(val< node.val) {
            return searchBST(node.left, val);
        }else if(val> node.val){
            return searchBST(node.right, val);
        }else {
            return node;
        }
    }
    /**
     * 非递归
     */
    public TreeNode searchBST2(TreeNode node,int val){
        if(node==null){
            return null;
        }
        while (node!=null){
            if (val<node.val){
                node=node.left;
            }else if(val>node.val){
                node=node.right;
            }else {
                break;
            }
        }
        return node;
    }
}
