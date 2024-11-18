package com.dataStructure.dataStructure.btree;

import java.util.Arrays;

/**
 * B-树
 */
public class BTree {

    //节点类
    static class Node {
        int[] keys;
        Node[] childrens;
        int keyNumber;//有效key的个数
        boolean leaf = true;//是否为叶子节点
        int t;//最小度数（最少孩子数）


        public Node(int t) {
            this.t = t;
            this.childrens = new Node[t * 2];
            this.keys = new int[t * 2 - 1];
        }

        public Node(int[] keys) {
            this.keys = keys;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }

        //多路查找
        Node get(int key) {
            int i = 0;
            while (i < keyNumber) {
                if (key == keys[i]) {
                    return this;
                }
                if (key < keys[i]) {
                    break;
                }
                i++;
            }
            //执行到这里，说明当前节点中没有值为key的键
            //如果当前节点为叶子节点，直接返回空
            if (leaf) {
                return null;
            }
            //如果当前节点为非叶子节点，则去索引为i的children中继续查找
            return childrens[i].get(key);
        }

        //向keys数组中index位置插入元素
        void insertKey(int key, int index) {
            //从后往前移动元素
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }

        //向children数组中index位置插入元素
        void insertChild(Node child, int index) {
            //从后往前移动元素
            System.arraycopy(childrens, index, childrens,
                    index + 1, keyNumber - index);
            childrens[index] = child;
        }

        //删除index索引的key
        int removeKey(int index) {
            int t = keys[index];
            System.arraycopy(keys, index + 1,
                    keys, index, --keyNumber - index);
            return t;
        }

        //删除最右边的key
        int removeRightmostKey() {
            return removeKey(keyNumber - 1);
        }

        //删除最左边的key
        int removeLeftmostKey() {
            return removeKey(0);
        }

        //删除index索引处的孩子
        Node removeChildren(int index) {
            Node t = childrens[index];
            System.arraycopy(childrens, index + 1,
                    childrens, index, keyNumber - index);
            childrens[keyNumber] = null;
            return t;
        }

        //删除最左边的孩子
        Node removeLeftmostChildren() {
            return removeChildren(0);
        }

        //删除最右边的孩子
        Node removeRightmostChildren() {
            return removeChildren(keyNumber);
        }

        //index孩子处左边的兄弟
        Node childLeftSibling(int index) {
            return index > 0 ? childrens[index - 1] : null;
        }

        //index孩子处右边的兄弟
        Node childRightSibling(int index) {
            return index == keyNumber ? null : childrens[index + 1];
        }

        //复制当前节点的所有key和child到target
        void moveToTarget(Node target) {
            int start = target.keyNumber;
            //如果是非叶子节点，将孩子复制到target
            if (!leaf) {
                for (int i = 0; i <= keyNumber; i++) {
                    target.childrens[start + i] = childrens[i];
                }
            }
            //将key复制到target
            for (int i = 0; i < keyNumber; i++) {
                target.keys[target.keyNumber++] = keys[i];
            }
        }
    }


    //根节点
    Node root;
    //B树的最小度数
    int t;
    //B树的最小key的个数
    final int MIN_KEY_NUMBER;
    //B树的最大key的个数
    final int MAX_KEY_NUMBER;

    public BTree() {
        this(2);
    }

    public BTree(int t) {
        this.t = t;
        root = new Node(t);
        MIN_KEY_NUMBER = t - 1;
        MAX_KEY_NUMBER = 2 * t - 1;
    }


    //是否存在
    public boolean contains(int key) {
        return root.get(key) != null;
    }


    //插入
    public void put(int key) {
        doPut(root, key, null, 0);
    }

    private void doPut(Node node, int key, Node parent, int index) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] == key) {
                return;//更新逻辑
            }
            if (node.keys[i] > key) {
                break;//找到了插入位置即为i
            }
            i++;
        }
        //如果当前节点为叶子节点，直接插入
        if (node.leaf) {
            node.insertKey(key, i);
        }
        //如果当前节点不是叶子节点，则递归到第i个孩子节点中继续插入
        else {
            doPut(node.childrens[i], key, node, i);
        }
        //如果有效key的数目等于了最大有效key的数目，则执行分裂方法
        if (node.keyNumber == MAX_KEY_NUMBER) {
            split(node, parent, index);
        }
    }

    /**
     * 分裂方法
     *
     * @param left   分裂节点
     * @param parent 分裂节点的父节点
     * @param index  分裂节点是第几个孩子
     */
    void split(Node left, Node parent, int index) {
        //情况一：要分裂的节点为根节点,创建新的根节点，把原来的根节点作为新根的第一个孩子
        if (parent == null) {
            Node newRoot = new Node(t);
            newRoot.leaf = false;
            newRoot.insertChild(left, 0);
            this.root = newRoot;
            parent = newRoot;
        }
        //1.创建right节点，把left节点中 t 之后的key和child移动过去
        Node right = new Node(t);
        //情况二：如果分裂节点为叶子节点，则分裂后的节点也一定为叶子节点
        right.leaf = left.leaf;
        System.arraycopy(left.keys, t, right.keys, 0, t - 1);
        //情况三：分裂节点为非叶子节点，要将其孩子的索引t之后的孩子移动到新节点中
        if (!left.leaf) {
            System.arraycopy(left.childrens, t, right.childrens, 0, t);
            for (int i = t; i <= left.keyNumber; i++) {
                left.childrens[i] = null;
            }
        }
        //更新分裂后各个节点的有效key的个数
        left.keyNumber = t - 1;
        right.keyNumber = t - 1;
        //2.分裂节点中间的key（t-1处）插入到父节点中
        int mid = left.keys[t - 1];
        parent.insertKey(mid, index);
        //3.right节点作为父节点的孩子
        parent.insertChild(right, index + 1);
    }

    //删除
    void remove(int key) {
        doRemove(null, root, 0, key);
    }

    private void doRemove(Node parent, Node node, int index, int key) {
        int i = 0;
        while (i < node.keyNumber) {
            if (node.keys[i] >= key) {
                break;
            }
            i++;
        }
        //如果是叶子节点
        if (node.leaf) {
            if (!found(node, key, i)) { //case1：没找到
                return;
            } else {//case2：找到了
                node.removeKey(i);
            }
        }
        //如果是非叶子节点
        else {
            if (!found(node, key, i)) {//case3：没找到
                doRemove(node, node.childrens[i], i, key);
            } else {//case4：找到了
                //1.找到后继key
                Node s = node.childrens[i + 1];
                while (!s.leaf) {
                    s = s.childrens[0];
                }
                int sKey = s.keys[0];
                //2.后继key替换待删除key
                node.keys[i] = sKey;
                //3.在后继子树中删除后继key
                doRemove(node, node.childrens[i + 1], i + 1, sKey);
            }
        }
        if (node.keyNumber < MIN_KEY_NUMBER) {
            // 如果删除后key的数量小于了最小key数，不平衡，需要调整
            // case5：删除后key数目 < 下限（不平衡）case6：根节点情况
            balance(parent, node, index);
        }
    }

    //parent 待调整节点父亲   x 待调整节点   i 待调整节点是第几个孩子
    private void balance(Node parent, Node x, int i) {
        //case6:根节点
        if (x == root) {
            if (root.keyNumber == 0 && root.childrens[0] != null) {
                root = root.childrens[0];
            }
            //特殊处理
            return;
        }
        Node left = parent.childLeftSibling(i);
        Node right = parent.childRightSibling(i);
        //case5.1:左兄弟有富余，右旋
        if (left != null && left.keyNumber > MIN_KEY_NUMBER) {
            //右旋
            // 1. 父节点中第i-1个key旋转下来做待调整节点的第一个key
            x.insertKey(parent.keys[i - 1], 0);
            // 2. 如果左兄弟非叶子节点，左兄弟的最大孩子作为被调整节点的最小孩子
            if (!left.leaf) {
                x.insertChild(left.removeRightmostChildren(), 0);
            }
            // 3. 左兄弟中最大key旋转到父节点中
            parent.keys[i - 1] = left.removeRightmostKey();
            return;
        }
        //case5.2:右兄弟有富余，左旋
        if (right != null && right.keyNumber > MIN_KEY_NUMBER) {
            //左旋
            // 1. 父节点中第i个key旋转下来做待调整节点最大的key
            x.insertKey(parent.keys[i], x.keyNumber);
            // 2. 如果右兄弟非叶子节点，将右兄弟的最小孩子作为待调整节点的最大孩子
            if (!right.leaf) {
                x.insertChild(right.removeLeftmostChildren(), x.keyNumber);
            }
            // 3. 右兄弟的最小key旋转到父节点中
            parent.keys[i] = right.removeLeftmostKey();
            return;
        }
        //case5.3:左右兄弟都没有富余，合并
        if (left != null) {
            // 如果有左兄弟,向左合并
            parent.removeChildren(i);//将待调整节点从父节点中删除
            //将父节点中小于待调整节点key的最大key添加到左兄弟的最右边
            left.insertKey(parent.removeKey(i - 1), left.keyNumber);
            //将待调整节点的key和child添加到左兄弟中，《向左兄弟合并》
            x.moveToTarget(left);
        } else {
            //如果没有左兄弟，向自身合并
            parent.removeChildren(i + 1);//将待调整节点的右兄弟从父节点中删除
            //将父节点中大于待调整节点的key的key添加到待调整节点的最右边
            x.insertKey(parent.removeKey(i), x.keyNumber);
            //将待调整节点的右兄弟的key和child添加到待调整节点中《向自身合并》
            right.moveToTarget(x);
        }
    }

    private boolean found(Node node, int key, int i) {
        return i < node.keyNumber && node.keys[i] == key;
    }
}
