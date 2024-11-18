package com.dataStructure.leetcode.design;

import java.util.Random;

/**
 * @author OldGj 2024/03/04
 * @version v1.0
 * @apiNote 跳表设计
 */
public class SkipListLeetcode1206 {

    /*
        第一轮有 500 个(level 1) >= 0.5 退出循环，剩下 500 个(level 2)
        第二轮有 250 个(level 2) >= 0.5 退出循环，剩下 125 个(level 3)
        第三轮有 63 个(level 3) >= 0.5 退出循环，剩下 62 个(level 4) 由于第二个条件退出循环
    */
    static Random random = new Random();

    static int random(int max) {
        int level = 1;
        while (level < max) {
            if (random.nextBoolean()) {
                return level;
            }
            level++;
        }
        return level;
    }

    /**
     * 跳表
     */
    static class Skiplist {

        private final Node head = new Node(-1); // 头结点
        private static final int MAX = 10; // 每个节点中维护数组的高度

        static class Node {
            private final int var;
            private final Node[] next = new Node[MAX];

            public Node(int var) {
                this.var = var;
            }
        }


        public Skiplist() {

        }

        /**
         * 查找目标元素并且记录查找的路径
         * @param target 目标元素
         * @return 查找过程的路径
         */
        private Node[] find(int target) {
            Node[] path = new Node[MAX];
            Node curr = head;
            for (int level = MAX - 1; level >= 0; level--) { // 从上向下找
                while (curr.next[level] != null && curr.next[level].var < target) { // 从左向右找
                    curr = curr.next[level];
                }
                path[level] = curr;
            }
            return path;
        }

        // 返回target是否存在于跳表中
        public boolean search(int target) {
            Node[] path = find(target);
            Node node = path[0].next[0];
            return node != null && node.var == target;
        }

        // 向跳表中添加元素
        public void add(int val) {
            // 1.确定添加位置（把 val 当做目标查询，经历的路径就可以确定添加位置）
            Node[] path = find(val);
            // 2.创建新节点并且随机高度
            Node node = new Node(val);
            int level = random(MAX);
            // 3.修改路径节点 next 指针，以及新节点 next 指针
            for (int i = 0; i < level; i++) {
                node.next[i] = path[i].next[i];
                path[i].next[i] = node;
            }
        }

        // 在跳表中删除一个值，如果num不存在，返回FALSE，如果存在多个num，删除其中任意一个
        public boolean erase(int num) {
            Node[] path = find(num);
            Node removed = path[0].next[0];
            if (removed == null || removed.var != num) {
                return false;
            }
            for (int i = 0; i < MAX; i++) {
                if (path[i].next[i] != removed) {
                    break;
                }
                path[i].next[i] = removed.next[i];
            }
            return true;
        }
    }
}
