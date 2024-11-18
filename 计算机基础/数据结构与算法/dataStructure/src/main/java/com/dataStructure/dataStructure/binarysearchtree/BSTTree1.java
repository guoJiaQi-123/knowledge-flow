package com.dataStructure.dataStructure.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树
 */
public class BSTTree1 {

    /**
     * 节点类
     */
    static class BSTNode {

        int key;// 若希望任意类型作为 key, 则后续可以将其设计为 Comparable 接口
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.value = key;
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    BSTNode root;//根节点

    /**
     * get方法实现
     */
    public Object get(int key) {
        //get方法非递归实现
        BSTNode node = root;
        while (node != null) {
            if (key < node.key) {
                node = node.left;
            } else if (node.key < key) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;

        //递归实现
        //return doGet(root, key);
    }

    //get方法递归实现【尾递归】
    private Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            return doGet(node.left, key);//在左子树中继续找
        } else if (node.key < key) {
            return doGet(node.right, key);//在右子树中继续找
        } else {
            return node.value;
        }
    }


    /**
     * 查找最小关键字对应的值
     */
    public Object min() {
        //非递归
        return min(root);

        // 递归
        //return doMin(root);
    }

    /**
     * 求任意节点为树根的最大节点
     * @param node 任意节点
     * @return 以node节点为根的树的最大节点
     */
    private Object min(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        // 左边未走到头
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    //递归查找最小关键字对应的值
    private Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }
        // 左边已走到头
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }


    /**
     * 查找最大关键字对应的值
     */
    public Object max() {
        //非递归
        return max(root);
        //递归
        //return doMax(root);
    }

    /**
     * 求任意节点为树根的最大节点
     *
     * @param node 任意节点
     * @return 以node节点为根的树的最大节点
     */
    private Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        // 根据二叉搜索树的定义，找最大节点即找到最靠右的节点即可
        BSTNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    //递归查找最大关键字对应的值 【尾递归】
    private Object doMax(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node.value;
        }
        return doMax(node.right);
    }

    /**
     * <h3>存储关键字和对应值</h3>
     *
     * @param key   关键字
     * @param value 值
     */
    public void put(int key, Object value) {
        BSTNode node = root;
        //定义一个变量存放如果树中不存在关键字为key的节点时，可以找到待新增的节点的父节点
        BSTNode parent = null;
        while (node != null) {
            //每次循环先将p走过的节点赋值给parent变量，其中最后一次赋值给parent的节点就是待新增节点的父节点
            //如果p指针指向null，不在执行该循环，则此时parent中存着的节点就是指向null之前的一个节点，即我们要找的父节点
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                // 情况一：原本树中存在key,则更新key对应节点的值为value
                node.value = value;
                return;
            }
        }
        //  情况二：原本树中不存在key,则新增一个关键字为key,对应值为value的节点加入到二叉搜索树
        //  想要新增节点，需要找到待新增节点的父节点，因为上面的p指针最后要指向null，而在指向null之前的一个节点就是我们要找的父节点

        //  判断：如果key大于父节点的key,新增节点应该作为父节点的右孩子，反之作为左孩子
        //  如果parent为空，说明压根没有走上面的while循环，说明root节点即为空，这是一颗空树，此时应该新增节点作为树的根节点
        if (parent == null) {
            root = new BSTNode(key, value);
        } else if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else {
            parent.right = new BSTNode(key, value);
        }
    }


    /**
     * <h3>查找关键字的前任值</h3>
     *
     * @param key 关键字
     * @return 前任值
     */
    public Object predecessor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromLeft = null; // 自左而来的祖先
        // 查找关键字节点
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                ancestorFromLeft = p; // 当遍历的节点需要向右走时，记录当前祖先的值即为遍历节点的自左而来的祖先
                p = p.right;
            } else {
                // 找到，退出循环
                break;
            }
        }
        //不存在当前关键字节点
        if (p == null) {
            return null;
        }
        //存在当前关键字节点
        //1.如果当前节点有左子树，则他的前任节点就是左子树中最大的节点
        if (p.left != null) {
            return max(p.left);
        }
        //2.如果当前节点没有左子树，则他的第一个自左而来的祖宗节点为前任节点
        return ancestorFromLeft != null ?
                ancestorFromLeft.value :
                null;
    }

    /**
     * <h3>查找关键字的后任值</h3>
     *
     * @param key 关键字
     * @return 后任值
     */
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null; // 自右而来的祖先节点
        // 查找关键字节点
        while (p != null) {
            if (key < p.key) {
                // 当遍历的节点需要向左走时，记录当前祖先的值即为遍历节点的自右而来的祖先
                ancestorFromRight = p;
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                // 找到，退出循环
                break;
            }
        }
        //不存在当前关键字节点
        if (p == null) {
            return null;
        }
        //存在当前关键字节点
        //1.如果当前节点有右子树，则右子树中最小节点就是当前节点的后任节点
        if (p.right != null) {
            return min(p.right);
        }
        //2.如果当前孩子没有右孩子，则其最近的自右而来的祖先节点就是其后任节点
        return ancestorFromRight != null ?
                ancestorFromRight.value :
                null;
    }

    /**
     * <h3>根据关键字删除</h3>
     *
     * @param key 关键字
     * @return 被删除关键字对应值
     */
    public Object remove(int key) {
        BSTNode p = root; // 待删除节点P
        BSTNode parent = null; // 待删除节点的父节点parent
        // 查找待删除节点
        while (p != null) {
            //  每次遍历下一个节点，将当前节点记录到parent中作为下一个节点的父节点
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (p.key < key) {
                parent = p;
                p = p.right;
            } else {
                // 找到待删除节点，退出循环
                break;
            }
        }
        // 如果没有找到待删除节点，返回null
        if (p == null) {
            return null;
        }
        // ----找到待删除节点
        //情况一：待删除节点有右孩子没有左孩子
        if (p.left == null) {
            shift(parent, p, p.right); // 将待删除节点的右孩子托孤给其父节点
        } else if (p.right == null) {  //情况二：待删除节点有左孩子没有右孩子
            shift(parent, p, p.left);  // 将待删除节点的左孩子托孤给其父节点
            //情况三：当被删除节点为叶子节点时【没有孩子，托孤null值】，无论走上面左子树为空还是右子树为空的逻辑都是可以的，因此不需另做考虑
        } else {
            //情况四：待删除节点既有左孩子又有右孩子
            //4.1:找待删除节点的后继节点【让待删除节点的后继节点替换删除节点，不会破坏二叉搜索树的性质】
            BSTNode s = p.right; // 后继节点s
            BSTNode sParent = p;//后继父亲
            // 找后继节点，并且在找后继的过程中记录后继节点的父节点
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            // ----s为待删除节点的后继节点

            //4.2：处理后继节点的后事
            if (sParent != p) {// 如果后继节点的父节点不是待删除节点，说明待删除节点和他的后继节点不相邻
                // 先将后继节点的右孩子托孤给后继节点的父节点【作为后继节点，不可能有左孩子】
                shift(sParent, s, s.right);
                // 后继节点顶上去以后，后继节点的右孩子需要更新为待删除节点的右孩子，这样才能做到替换待删除节点
                s.right = p.right;
            }
            //4.3后继节点替换掉待删除节点
            shift(parent, p, s);
            // 后继节点的左孩子需要更新为待删除节点的左孩子，这样才能做到替换待删除节点
            s.left = p.left;
        }
        // 返回待删除节点的值
        return p.value;
    }

    /**
     * 托孤方法
     *
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    /**
     * <h3>根据关键字删除 -- 递归</h3>
     *
     * @param key 关键字
     * @return 被删除关键字对应值
     */
    public Object delete(int key) {
        ArrayList<Object> result = new ArrayList<>();
        root = doDelete(root, key, result);
        return result.isEmpty() ? null : result.get(0);
    }


    /*
              4
             / \
            2   6
           /     \
          1       7

        node 起点
        返回值 删剩下的孩子(找到) 或 null(没找到)
     */
    private BSTNode doDelete(BSTNode node, int key, ArrayList<Object> result) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = doDelete(node.left, key, result);
            return node;
        }
        if (node.key < key) {
            node.right = doDelete(node.right, key, result);
            return node;
        }
        result.add(node.value);
        if (node.left != null && node.right != null) {
            BSTNode s = node.right;
            while (s.left != null) {
                s = s.left;
            }
            s.right = doDelete(node.right, s.key, new ArrayList<>());
            s.left = node.left;
            return s;
        }
        return node.left != null ? node.left : node.right;
    }


    //范围查找

    //查找比key小的
    public List<Object> less(int key) {
        List<Object> result = new ArrayList<>();
        BSTNode curr = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BSTNode pop = stack.pop();
                //处理结果
                if (pop.key < key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                curr = pop.right;
            }
        }
        return result;
    }

    //查找比key大的
    public List<Object> greater(int key) {
        List<Object> result = new ArrayList<>();
        BSTNode curr = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.right;
            } else {
                BSTNode pop = stack.pop();
                //处理结果
                if (pop.key > key) {
                    result.add(pop.value);
                } else {
                    break;
                }
                curr = pop.left;
            }
        }
        return result;
    }

    //查找在key1和key2之间的
    public List<Object> between(int key1, int key2) {
        List<Object> result = new ArrayList<>();
        BSTNode curr = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                BSTNode pop = stack.pop();
                //处理结果
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                } else if (pop.key > key2) {
                    break;
                }
                curr = pop.right;
            }
        }
        return result;
    }
}
