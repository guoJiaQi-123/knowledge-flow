package com.dataStructure.leetcode.design;


import java.util.HashMap;

/**
 * @author OldGj 2024/03/03
 * @version v1.0
 * @apiNote 146. LRU 缓存
 */
public class LRUCacheLeetcode146 {
    static class LRUCache {

        private final int capacity;
        private final HashMap<Integer, Node> map = new HashMap<>();
        private final DoubleLinkedList list = new DoubleLinkedList();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                list.remove(node);
                list.addFirst(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) { // 更新逻辑
                Node node = map.get(key);
                node.value = value;
                list.remove(node);
                list.addFirst(node);
            } else { // 添加逻辑
                Node node = new Node(key, value);
                map.put(key, node); // hash表中添加数据
                list.addFirst(node); // 双向链表头添加数据
                if (map.size() > capacity) { // 超出容量，删除链表尾部数据即可
                    Node removed = list.removeLast(); // 在链表中删除最久不用的数据
                    map.remove(removed.key); // 在map中删除最久不用的数据
                }
            }
        }

        // 链表节点，存放数据
        static class Node {
            private Node prev;
            private Node next;
            private final int key;
            private int value;


            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        // 定义一个双向链表用于按顺序存储最新使用过的数据
        // 越靠近链表头表示最新被操作过的数据，链表尾部的表示很久没有操作的数据
        // 每次查询数据或者添加数据，只需要将这个数据加入链表头，如果超过容量，则删除链表尾部数据即可
        static class DoubleLinkedList {
            private final Node head;
            private final Node tail;

            public DoubleLinkedList() {
                head = tail = new Node(-1, -1);
                head.next = tail;
                tail.prev = head;
            }

            // 从头部添加
            public void addFirst(Node newFirst) { // O(1)
                Node oldFirst = head.next;
                newFirst.prev = head;
                newFirst.next = oldFirst;
                head.next = newFirst;
                oldFirst.prev = newFirst;
            }

            // 删除已知节点
            public void remove(Node node) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
            }

            // 删除尾部节点
            public Node removeLast() {
                Node lastNode = tail.prev;
                remove(lastNode);
                return lastNode;
            }
        }
    }
}
