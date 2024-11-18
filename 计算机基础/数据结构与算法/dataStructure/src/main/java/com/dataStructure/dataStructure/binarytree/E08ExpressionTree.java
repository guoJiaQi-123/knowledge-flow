package com.dataStructure.dataStructure.binarytree;


import java.util.LinkedList;

/**
 * 根据后缀表达式构造表达式树
 */
public class E08ExpressionTree {
    static class TreeNode {
        TreeNode left;
        String val;
        TreeNode right;

        public TreeNode(TreeNode left, String val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        public TreeNode(String val) {
            this.val = val;
        }
    }


    /*
        中缀表达式           (2-1)*3
        后缀（逆波兰）表达式   21-3*

        1.遇到数字入栈
        2.遇到运算符, 出栈两次, 与当前节点建立父子关系, 当前节点入栈

        [1,2,*,5,+]

        /   /
        /   /
        / 2 /
        / 1 /
        -----

        如果遇到数字，则入栈，如果遇到运算符，则将栈顶的两个元素出栈，
        并且最先出栈的节点作为运算符节点的右孩子，第二个出栈的节点作为运算符节点的左孩子


        表达式树
            *
           / \
          -   3
         / \
        2   1

        21-3*

     */
    public TreeNode constructExpressionTree(String[] array) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String t : array) {
            switch (t) {
                case "+", "-", "*", "/" -> {// 运算符
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode parent = new TreeNode(left, t, right);
                    stack.push(parent);
                }
                default -> {// 数字
                    stack.push(new TreeNode(t));
                }
            }
        }
        return stack.peek();
    }
}
