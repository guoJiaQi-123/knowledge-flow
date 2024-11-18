package com.dataStructure.dataStructure.redblacktree;

/**
 * <h3>红黑树</h3>
 */
public class RedBlackTree {

    enum Color {
        RED, BLACK;
    }

    static class RedBlackNode {
        int key;
        Object value;
        RedBlackNode left;
        RedBlackNode right;
        RedBlackNode parent;        //父节点
        Color color = Color.RED;//节点默认为红色


        public RedBlackNode(int key) {
            this.key = key;
        }

        public RedBlackNode(int key, Color color) {
            this.key = key;
            this.color = color;
        }

        public RedBlackNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }


        public RedBlackNode(int key, Color color, RedBlackNode left, RedBlackNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.color = color;
            if (left != null) {
                left.parent = this;
            }
            if (right != null) {
                right.parent = this;
            }
        }

        //判断节点是否为左孩子
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        //叔叔
        RedBlackNode uncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }

            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        //兄弟
        RedBlackNode sibling() {
            if (parent == null) {
                return null;
            }

            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }
    }

    RedBlackNode root;

    public boolean contains(int key) {
        return find(key) != null;
    }

    //判断红
    boolean isRed(RedBlackNode node) {
        return node != null && node.color == Color.RED;
    }

    //判断黑
    boolean isBlack(RedBlackNode node) {
        return node == null || node.color == Color.BLACK;
    }

    //右旋    1. parent  2. 新根的父子关系
    private void rightRotate(RedBlackNode pink) {
        RedBlackNode parent = pink.parent;
        RedBlackNode yellow = pink.left;
        RedBlackNode green = yellow.right;
        yellow.parent = parent;
        yellow.right = pink;
        pink.parent = yellow;
        pink.left = green;
        if (green != null) {
            green.parent = pink;
        }
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    //左旋    1. parent  2. 新根的父子关系
    private void leftRotate(RedBlackNode pink) {
        RedBlackNode parent = pink.parent;
        RedBlackNode yellow = pink.right;
        RedBlackNode green = yellow.left;
        yellow.parent = parent;
        yellow.left = pink;
        pink.parent = yellow;
        pink.right = green;
        if (green != null) {
            green.parent = pink;
        }
        if (parent == null) {
            root = yellow;
        } else if (parent.left == pink) {
            parent.left = yellow;
        } else {
            parent.right = yellow;
        }
    }

    //添加元素
    public void put(int key, Object value) {
        RedBlackNode p = root;
        RedBlackNode parent = null;
        while (p != null) {
            parent = p;
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {//更新
                p.value = value;
                return;
            }
        }
        RedBlackNode inserted = new RedBlackNode(key, value);
        if (parent == null) {
            root = inserted;
        } else if (key < parent.key) {
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            parent.right = inserted;
            inserted.parent = parent;
        }
        fixRedRed(inserted);
    }

    //解决红红不平衡
    private void fixRedRed(RedBlackNode x) {

        // case 1 插入节点是根节点，变黑即可
        if (root == x) {
            x.color = Color.BLACK;
            return;
        }
        // case 2 插入节点父亲是黑色，无需调整
        if (isBlack(x.parent)) {
            return;
        }
        //父亲
        RedBlackNode parent = x.parent;
        //叔叔
        RedBlackNode uncle = x.uncle();
        //祖父
        RedBlackNode grandParent = parent.parent;
        // case 3 (当红红相邻，叔叔为红时)插入节点的父亲是红色的，叔叔也是红色的
        // 需要将父亲、叔叔变黑、祖父变红，然后对祖父做递归处理

        if (isRed(parent) && isRed(uncle)) {
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandParent.color = Color.RED;
            fixRedRed(grandParent);
            return;
        }

        // case 4 (当红红相邻，叔叔为黑时)插入节点的父亲是红色的，叔叔是黑色的
        //  LL 父亲是左孩子 待插入节点也是左孩子
        //  LR 父亲是左孩子 待插入节点是右孩子
        //  RR 父亲是右孩子 待插入节点也是右孩子
        //  RL 父亲是右孩子 待插入节点是左孩子
        if (parent.isLeftChild() && x.isLeftChild()) { //LL
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            rightRotate(grandParent);
        } else if (parent.isLeftChild() && !x.isLeftChild()) { //LR
            leftRotate(parent);
            x.color = Color.BLACK;
            grandParent.color = Color.RED;
            rightRotate(grandParent);
        } else if (!parent.isLeftChild() && !x.isLeftChild()) { //RR
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            leftRotate(grandParent);
        } else { //RL
            rightRotate(parent);
            x.color = Color.BLACK;
            grandParent.color = Color.RED;
            leftRotate(grandParent);
        }

    }


    public void remove(int key) {
        RedBlackNode deleted = find(key);
        if (deleted == null) {
            return;
        }
        doRemove(deleted);
    }

    //递归方法
    private void doRemove(RedBlackNode deleted) {
        RedBlackNode replaced = findReplaced(deleted);
        RedBlackNode parent = deleted.parent;
        // 没有孩子
        if (replaced == null) {
            //case1:删除的是根节点
            if (deleted == root) {
                root = null;
            } else {
                // 先调整平衡
                if (isBlack(deleted)) {
                    //复杂处理
                    fixDoubleBlack(deleted);
                } else {
                    //删除的节点为红色叶子节点，不需要任何处理
                }

                // 待删除节点为左孩子
                if (deleted.isLeftChild()) {
                    parent.left = null;
                } else {//待删除节点为又孩子
                    parent.right = null;
                }
            }
            return;
        }
        // 有一个孩子
        if (deleted.left == null || deleted.right == null) {
            //case1:删除的是根节点
            if (deleted == root) {
                root.value = replaced.value;
                root.key = replaced.key;
                root.left = root.right = null;
            } else {
                if (deleted.isLeftChild()) {
                    parent.left = replaced;
                } else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;

                //后调整平衡
                if (isBlack(deleted) && isBlack(replaced)) {
                    //复杂处理
                    fixDoubleBlack(replaced);
                } else if (isBlack(deleted) && isRed(replaced)) {
                    //case2：删除的节点是黑节点，待替换节点为红节点--只需要将待替换节点还为红黑节点即可
                    replaced.color = Color.BLACK;
                }
                return;
            }
        }
        // case0:有两个孩子
        int t = replaced.key;
        replaced.key = deleted.key;
        deleted.key = t;

        Object v = replaced.value;
        replaced.value = deleted.value;
        deleted.value = v;
        doRemove(replaced);
    }

    //处理删除黑色节点，待替换节点也为黑色的复杂情况(处理双黑)
    private void fixDoubleBlack(RedBlackNode x) {
        if (x == root) {
            return;
        }
        //父亲
        RedBlackNode parent = x.parent;
        //兄弟
        RedBlackNode sibling = x.sibling();
        //case3:兄弟为红色
        if (isRed(sibling)) {
            if (x.isLeftChild()) {
                leftRotate(parent);
            } else {
                rightRotate(parent);
            }
            parent.color = Color.RED;
            sibling.color = Color.BLACK;
            fixDoubleBlack(x);
            return;
        }

        if (sibling != null) {
            //case4:兄弟为黑色，侄子也都是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                sibling.color = Color.RED;
                if (isRed(parent)) {
                    parent.color = Color.BLACK;//如果父亲是红色，则将父亲变为黑色即可
                } else {
                    fixDoubleBlack(parent);//如果父亲也是黑色，则将父亲作为参数触发双黑，递归操作
                }
            }
            //case5:兄弟为黑色，侄子中有红色
            else {
                //LL
                if (sibling.isLeftChild() && isRed(sibling.left)) {
                    rightRotate(parent);
                    sibling.left.color = Color.BLACK;
                    sibling.color = parent.color;
                }
                //LR
                else if (sibling.isLeftChild() && isRed(sibling.right)) {
                    sibling.right.color = parent.color;
                    leftRotate(sibling);
                    rightRotate(parent);
                }
                //RR
                else if (!sibling.isLeftChild() && isRed(sibling.right)) {
                    leftRotate(parent);
                    sibling.right.color = Color.BLACK;
                    sibling.color = parent.color;
                }
                //RL
                else if (!sibling.isLeftChild() && isRed(sibling.left)) {
                    sibling.left.color = parent.color;
                    rightRotate(sibling);
                    leftRotate(parent);
                }
                parent.color = Color.BLACK;
            }

        } else {
            fixDoubleBlack(parent);
        }
    }


    //查找待删除节点
    private RedBlackNode find(int key) {
        RedBlackNode p = root;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    //查找替换节点
    private RedBlackNode findReplaced(RedBlackNode deleted) {
        //待删除节点没有孩子
        if (deleted.left == null && deleted.right == null) {
            return null;
        }
        if (deleted.left == null) {
            return deleted.right;
        }
        if (deleted.right == null) {
            return deleted.left;
        }
        RedBlackNode s = deleted.right;
        while (s.left != null) {
            s = s.left;
        }
        return s;
    }

}
