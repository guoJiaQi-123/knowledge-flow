package com.dataStructure.dataStructure.binarysearchtree;


import com.dataStructure.dataStructure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class E05Leetcode938 {
    public int rangeSumBST1(TreeNode root, int low, int high) {
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();
                if(pop.val>high){
                    break;
                }
                if (pop.val >= low) {
                    sum += pop.val;
                }
                p = pop.right;
            }
        }
        return sum;
    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        //如果root小于下限，则返回root的右子树中符合上下限的值
        if(root.val<low){
            return rangeSumBST(root.right,low,high);
        }
        //如果root大于上限，则返回root的左子树中符合上下限的值
        if(root.val>high){
            return rangeSumBST(root.left,low,high);
        }
        //当root的值在上下限范围内，返回root的值＋左子树中符合上下限的值＋右子树中符合上下限的值
        return root.val + rangeSumBST(root.right,low,high) + rangeSumBST(root.left,low,high);
    }

}
