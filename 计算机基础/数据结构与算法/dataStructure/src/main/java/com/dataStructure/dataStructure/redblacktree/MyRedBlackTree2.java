package com.dataStructure.dataStructure.redblacktree;

public class MyRedBlackTree2 {

    public boolean contains(int key) {
        return find(key) != null;
    }

    enum Color {
        RED, BLACK;
    }

    static class RedBlackNode2 {
        int key;
        Object value;
        RedBlackNode2 left;
        RedBlackNode2 right;
        RedBlackNode2 parent;
        Color color = Color.RED;


        public RedBlackNode2(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public RedBlackNode2(int key, Color color) {
            this.key = key;
            this.color = color;
        }

        public RedBlackNode2(int key, MyRedBlackTree2.Color color, RedBlackNode2 left, RedBlackNode2 right) {

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

        //判断当前节点是否为左孩子
        boolean isLeftChild() {
            //父亲不为空且父亲的左孩子为当前节点
            return parent != null && parent.left == this;
        }

        //叔叔
        RedBlackNode2 uncle() {
            //想要有叔叔，必须有父亲和祖父
            if (parent == null || parent.parent == null) {
                return null;
            }
            //如果父亲为左孩子，返回祖父的右孩子，否则返回祖父的左孩子
            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        //兄弟
        RedBlackNode2 sibling() {
            //想要有兄弟，必须有父亲
            if (parent == null) {
                return null;
            }
            //如果当前节点为父亲的左孩子，则返回父亲的右孩子，否则返回父亲的左孩子
            if (this.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }
    }

    //根节点
    RedBlackNode2 root;

    //判断红
    boolean isRed(RedBlackNode2 node) {
        return node != null && node.color == Color.RED;
    }

    //判断黑
    boolean isBlack(RedBlackNode2 node) {
        return node == null || node.color == Color.BLACK;
    }

    //右旋   1.parent指向  2.与原来pink的父亲建立父子关系
    private void rightRotate(RedBlackNode2 pink) {
        RedBlackNode2 parent = pink.parent;
        RedBlackNode2 yellow = pink.left;
        RedBlackNode2 green = yellow.right;
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

    //左旋
    private void leftRotate(RedBlackNode2 pink) {
        RedBlackNode2 parent = pink.parent;
        RedBlackNode2 yellow = pink.right;
        RedBlackNode2 green = yellow.left;
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

    //红黑树添加方法
    public void put(int key, Object value) {
        RedBlackNode2 p = root;
        RedBlackNode2 parent = null;
        while (p != null) {
            parent = p;
            if (key < p.key) {
                p = p.left;
            } else if (key > p.key) {
                p = p.right;
            } else {
                p.value = value;//找到了执行更新逻辑
                return;
            }
        }
        //执行到这里，说明需要创建新节点进行插入
        RedBlackNode2 inserted = new RedBlackNode2(key, value);
        // 情况1.如果父节点为空，此时为空树，插入节点做根
        // 情况2.如果插入节点的key小于父节点的key，插入节点做父节点的左孩子
        // 情况3.如果插入节点的key大于父节点的key，插入节点做父节点的左孩子
        if (parent == null) {
            root = inserted;
        } else if (key < parent.key) {
            //建立父 子关系
            parent.left = inserted;
            inserted.parent = parent;
        } else {
            //建立父 子关系
            parent.right = inserted;
            inserted.parent = parent;
        }
        //如果插入节点后，触发红红相邻，则进行平衡调整
        fixRedRed(inserted);
    }

    //解决红红不平衡
    private void fixRedRed(RedBlackNode2 inserted) {

        // 情况1：插入的节点作为根节点
        // 解决方法：直接将根节点颜色变为黑色即可
        if (inserted == root) {
            inserted.color = Color.BLACK;
            return;
        }
        // 情况2：插入的节点的父节点为黑色，树的红黑性质不变，此时不会触发红红不平衡
        if (isBlack(inserted.parent)) {
            return;
        }
        //父亲
        RedBlackNode2 parent = inserted.parent;
        //祖父
        RedBlackNode2 grandParent = parent.parent;
        //叔叔
        RedBlackNode2 uncle = inserted.uncle();
        // 情况3：如果插入节点的父节点为红色，且其叔叔节点也为红色
        // 解决方法：父节点变黑，叔叔节点变黑，祖父节点变红，递归解决祖父变红带来的红红不平衡问题
        if (isRed(parent) && isRed(uncle)) {
            parent.color = Color.BLACK;
            uncle.color = Color.BLACK;
            grandParent.color = Color.RED;
            fixRedRed(grandParent);
            return;
        }
        // 情况4：如果插入节点的父节点为红色，且叔叔节点为黑色
        // 解决方法：
        // 情况4.1：父节点为左孩子，插入节点为左孩子，触发LL不平衡，父变黑，祖父变红，祖父右旋
        // 情况4.2：父节点为左孩子，插入节点为右孩子，触发LR不平衡，父亲左旋变成LL不平衡，插入变黑，祖父变红，祖父右旋
        // 情况4.3：父节点为右孩子，插入节点为右孩子，触发RR不平衡，父变黑，祖父变红，祖父左旋
        // 情况4.4：父节点为右孩子，插入节点为左孩子，触发RL不平衡，父亲右旋变成RR不平衡，插入变黑，祖父变红，祖父右旋

        if (parent.isLeftChild() && inserted.isLeftChild()) {//LL
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            rightRotate(grandParent);
        } else if (parent.isLeftChild() && !inserted.isLeftChild()) {//LR
            leftRotate(parent);
            inserted.color = Color.BLACK;
            grandParent.color = Color.RED;
            rightRotate(grandParent);
        } else if (!parent.isLeftChild() && !inserted.isLeftChild()) {//RR
            parent.color = Color.BLACK;
            grandParent.color = Color.RED;
            leftRotate(grandParent);
        } else if (!parent.isLeftChild() && inserted.isLeftChild()) {//RL
            rightRotate(parent);
            inserted.color = Color.BLACK;
            grandParent.color = Color.RED;
            leftRotate(grandParent);
        }

    }

    //红黑树删除方法
    public void remove(int key) {
        RedBlackNode2 deleted = find(key);
        if (deleted == null) {
            return;
        }
        doRemove(deleted);
    }

    private void doRemove(RedBlackNode2 deleted) {
        //待删除节点父亲
        RedBlackNode2 parent = deleted.parent;
        //替换节点
        RedBlackNode2 replaced = replaced(deleted);
        //情况1：待删除节点没有左右孩子
        if (replaced == null) {
            //情况1.1：待删除节点为根节点
            if (deleted == root) {
                root = null;
            }
            //情况1.2：待删除节点不是根节点
            else {
                //情况1.2.1：如果待删除节点为黑色节点，则需要调整平衡
                if (isBlack(deleted)) {
                    // 先调整平衡
                    //复杂处理
                    fixDoubleBlack(deleted);
                }
                //情况1.2.2：如果删除的节点为红色叶子节点，不需要任何处理
                else {
                    //不做任何处理。
                }

                //删除节点
                if (deleted.isLeftChild()) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            return;
        }
        //情况2：待删除节点只有一个孩子
        if (deleted.right == null || deleted.left == null) {
            //情况2.1：删除节点为根节点
            if (deleted == root) {
                root.value = replaced.value;
                root.key = replaced.key;
                root.left = root.right = null;
            }
            //情况2.2：待删除节点不是根节点
            else {
                //删除节点
                if (deleted.isLeftChild()) {
                    parent.left = replaced;
                } else {
                    parent.right = replaced;
                }
                replaced.parent = parent;
                deleted.left = deleted.right = deleted.parent = null;


                //情况2.2.1：如果待删除节点和替换节点都为黑色
                if (isBlack(deleted) && isBlack(replaced)) {
                    //复杂处理
                    fixDoubleBlack(replaced);
                }
                //情况2.2.2：如果待删除节点为黑色，替换节点为红色
                //解决方法：直接将替换节点变为黑色即可
                else if (isBlack(deleted) && isRed(replaced)) {
                    replaced.color = Color.BLACK;
                }
                return;
            }
        }
        //情况3：待删除节点有左右孩子
        //处理方法：李代桃僵，将删除节点和待替换节点的key和value进行替换，就可以删除待替换节点
        //通过上面的处理方法，可以将删除节点转换成有一个孩子或者没有孩子的情况。
        int t = replaced.key;
        replaced.key = deleted.key;
        deleted.key = t;

        Object v = replaced.value;
        replaced.value = deleted.value;
        deleted.value = v;
        doRemove(replaced);
    }

    //删除节点和剩下节点都是黑，触发双黑，双黑意思是，少了一个黑
    private void fixDoubleBlack(RedBlackNode2 deleted) {
        if (deleted == root) {
            return;
        }
        //被删除及节点的兄弟
        RedBlackNode2 sibling = deleted.sibling();
        //被删除节点父亲
        RedBlackNode2 parent = deleted.parent;
        //情况1：被删除节点的兄弟为红
        if (isRed(sibling)) {
            //情况1.1：被删除节点为左孩子，被删除节点的父亲左旋
            if (deleted.isLeftChild()) {
                leftRotate(parent);
            }
            //情况1.2：被删除节点为右孩子，被删除节点的父亲右旋
            else {
                rightRotate(parent);
            }
            //父亲颜色变红
            parent.color = Color.RED;
            //兄弟颜色变黑
            sibling.color = Color.BLACK;
            //递归调用删除
            fixDoubleBlack(deleted);
            return;
        }


        //情况2：被删除节点的兄弟也为黑色且两个侄子也都为黑色
        if (isBlack(sibling.left) && isBlack(sibling.right)) {
            sibling.color = Color.RED;
            //情况2.1：父亲为红，则将父亲变黑，兄弟变红，此时路径黑节点数目不变
            if (isRed(parent)) {
                parent.color = Color.BLACK;

            }
            //情况2.2：父亲也为黑，则将父亲继续触发双黑
            else {
                fixDoubleBlack(parent);
            }
        } else {
            //情况3：被删除节点的兄弟为黑，但侄子中至少有一个红

            //情况3.1：删除节点的兄弟为左孩子，红节点侄子为左孩子LL
            if (sibling.isLeftChild() && isRed(sibling.left)) {
                rightRotate(parent);
                sibling.left.color = Color.BLACK;
                sibling.color = parent.color;
                parent.color = Color.BLACK;
            }
            //情况3.2：删除节点的兄弟为左孩子，红节点侄子为右孩子LR
            else if (sibling.isLeftChild() && isRed(sibling.right)) {
                sibling.right.color = parent.color;
                leftRotate(sibling);
                rightRotate(parent);
                parent.color = Color.BLACK;
            }
            //情况3.3：删除节点的兄弟为右孩子，红节点侄子为右孩子RR
            else if (!sibling.isLeftChild() && isRed(sibling.right)) {
                leftRotate(parent);
                sibling.right.color = Color.BLACK;
                sibling.color = parent.color;
                parent.color = Color.BLACK;
            }
            //情况3.4：删除节点的兄弟为右孩子，红节点侄子为左孩子RL
            else if (!sibling.isLeftChild() && isRed(sibling.left)) {
                sibling.left.color = parent.color;
                rightRotate(sibling);
                leftRotate(parent);
                parent.color = Color.BLACK;
            }

        }


    }


    //查找节点
    private RedBlackNode2 find(int key) {
        RedBlackNode2 p = root;
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

    //查找删除后要替换节点方法
    private RedBlackNode2 replaced(RedBlackNode2 deleted) {
        //情况1：待删除节点没有左右孩子
        if (deleted.left == null && deleted.right == null) {
            return null;
        }
        //情况2：待删除节点有左孩子，没有右孩子
        if (deleted.right == null) {
            return deleted.left;
        }
        //情况3：待删除节点有右孩子，没有左孩子
        if (deleted.left == null) {
            return deleted.right;
        }
        //情况4：待删除节点有左右孩子
        RedBlackNode2 s = deleted.right;//后继节点
        while (s.left != null) {
            s = s.left;
        }

        return s;
    }


}
