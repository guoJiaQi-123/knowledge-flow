package com.dataStructure.dataStructure.binarytree;

public class TreeTraversal {
    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        preOrder(root);
        System.out.println();

        inOrder(root);
        System.out.println();

        postOrder(root);
        System.out.println();
    }

    /**
     * <h3>前序遍历</h3>
     *
     * @param root 根节点
     */
    private static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root + "\t");
        preOrder(root.left);            //左
        preOrder(root.right);           //右
    }

    /**
     * <h3>中序遍历</h3>
     *
     * @param root 根节点
     */
    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);             //左
        System.out.print(root + "\t");
        inOrder(root.right);            //右
    }

    /**
     * <h3>后序遍历</h3>
     *
     * @param root 根节点
     */
    private static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);           //左
        postOrder(root.right);          //右
        System.out.print(root + "\t");
    }


}
