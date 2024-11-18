package com.dataStructure.dataStructure.binarysearchtree;

import com.dataStructure.dataStructure.binarytree.TreeNode;

/**
 * 二叉搜索树的最近公共祖先
 * 点：若 p，q 在 ancestor 的两侧，则 ancestor 就是它们的最近公共祖先
 */
public class E07Leetcode235 {
    /**
     * 思路：当 p 和 q 在一个节点的两侧时（包括p或q等于公共节点），则这个节点就是最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        //  q 和 p 在curr节点的同一侧，需要继续查找
        while (curr.val > p.val && curr.val > q.val || curr.val < p.val && curr.val < q.val) {
            if (curr.val > p.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return curr;
    }
}
