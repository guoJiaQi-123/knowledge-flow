package com.dataStructure.dataStructure.AVLTree;

/**
 * AVL树<br></br>
 * <br></br>
 * <b>·</b>  二叉搜索树在插入和删除时，节点可能失衡<br></br>
 * <b>·</b>  如果在插入和删除时通过旋转，始终让二叉搜索树保持平衡，则称为自平衡的二叉搜索树<br></br>
 * <b>·</b>  AVL是自平衡二叉搜索树的实现之一<br></br>
 */
public class AVLTree {

    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;//高度

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key) {
            this.key = key;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    //求节点的高度
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    //更新节点高度（新增，删除，旋转）
    private void updateHeight(AVLNode node) {
        //在node左右孩子中取较大值 + 1
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
    }

    //计算平衡因子（balance factor） = 左孩子高度 - 右孩子高度
    private int balanceFactor(AVLNode node) {
        return height(node.left) - height(node.right);
    }

    //左旋  参数：要旋转的节点   返回值：旋转后新的根节点
    private AVLNode leftRotate(AVLNode red) {
        AVLNode yellow = red.right;
        AVLNode green = yellow.left;
        yellow.left = red;
        red.right = green;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    //右旋  参数：要旋转的节点   返回值：旋转后新的根节点
    private AVLNode rightRotate(AVLNode red) {
        AVLNode yellow = red.left;
        AVLNode green = yellow.right;
        yellow.right = red;
        red.left = green;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    //左右旋。针对于不平衡节点左高，左孩子右高
    private AVLNode leftRightRotate(AVLNode root) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }

    //右左旋。针对于不平衡节点右高，右孩子左高
    private AVLNode rightLeftRotate(AVLNode root) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }


    //判断及调整平衡代码，参数：不平衡节点  通过旋转使其平衡
    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        int balanceFactor = balanceFactor(node);
        if (balanceFactor > 1 && balanceFactor(node.left) >= 0) {//LL
            return rightRotate(node);
        } else if (balanceFactor > 1 && balanceFactor(node.left) < 0) {//LR
            return leftRightRotate(node);
        } else if (balanceFactor < -1 && balanceFactor(node.right) > 0) {//RL
            return rightLeftRotate(node);
        } else if (balanceFactor < -1 && balanceFactor(node.right) <= 0) {//RR
            return rightRotate(node);
        }
        return node;
    }

    AVLNode root;

    // 添加节点
    public void put(int key, Object value) {
        root = doPut(root, key, value);
    }

    // 新增节点的递归 辅助方法 用来查找合适的位置并且新增节点，建立父子关系
    private AVLNode doPut(AVLNode node, int key, Object value) {
        if (node == null) {
            return new AVLNode(key, value);
        }
        if (key == node.key) {
            node.value = value;
        }
        if (key < node.key) {
            node.left = doPut(node.left, key, value);//向左找，并建立父子关系
        } else {
            node.right = doPut(node.right, key, value);//向右找，并建立父子关系
        }
        updateHeight(node); //在递归弹栈时候一层一层更新节点高度
        return balance(node);//返回平衡后的根节点，可以使二叉搜索树在执行完更新操作后转换为平衡二叉搜索树
    }

    // 删除节点
    public void remove(int key) {
        root = doRemove(root, key);
    }

    //  删除节点的递归 辅助方法 用来删除节点并且返回删除后的节点
    private AVLNode doRemove(AVLNode node, int key) {
        // 1. node为null，直接返回null
        if (node == null) {
            return null;
        }
        // 2. 没找到待删除节点，继续找
        if (key < node.key) {
            node.left = doRemove(node.left, key);
        } else if (key > node.key) {
            node.right = doRemove(node.right, key);
        } else {
            // 3. 找到待删除节点   待删除节点  1):没有孩子  2):只有左孩子   3):只有右孩子   4):右两个孩子
            if (node.right == null && node.left == null) {
                return null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                AVLNode s = node.right;//找后继节点
                while (s.left != null) {
                    s = s.left;
                }
                s.right = doRemove(node.right, s.key);
                s.left = node.left;
                node = s;
            }
        }
        updateHeight(node);
        return balance(node);
    }

}
