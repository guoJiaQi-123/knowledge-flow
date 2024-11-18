package com.dataStructure.leetcode.design;

import java.util.HashMap;

/**
 * @author OldGj 2024/03/04
 * @version v1.0
 * @apiNote 460.LFU 缓存
 */
public class LFUCacheLeetcode460 {


    static class LFUCache {
        private final HashMap<Integer, Node> kvMap = new HashMap<>();
        private final HashMap<Integer, DoubleLinkedList> freqMap = new HashMap<>();
        private final int capacity;
        private int minFreq = 1;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        /**
         * 从LFU缓存中获取数据，并且更新数据的使用频率以及freqMap
         */
        public int get(int key) {
            Node node = kvMap.get(key);
            if (node == null) { // 如果数据不存在，返回-1
                return -1;
            }
            int oldFreq = node.freq;
            DoubleLinkedList oldFreqList = freqMap.get(oldFreq);
            oldFreqList.remove(node); // 将该数据从旧频率表中删除
            // 如果查询的数据是最小频率的数据并且频率增加后，最小频率数据没有了，则更新维护的最小频率数据
            if (oldFreq == minFreq && oldFreqList.isEmpty()) {
                minFreq++;
            }
            node.freq++; // 频率++
            int newFreq = node.freq;
            // 如果newFreq在频率表中存在，则直接返回，如果不存在则返回一个新的链表
            DoubleLinkedList list = freqMap.computeIfAbsent(newFreq, k -> new DoubleLinkedList());
            list.addFirst(node); // 将更新了频率的新节点数据更新到频率表中
            return node.value;
        }

        /**
         * 向LFU缓存中添加数据，如果key对应的数据原本存在，则执行更新逻辑，如果不存在，则添加数据
         * 如果在添加数据之前，容量已经满了，则先将使用频率最少，存在时间最长的数据删除，再执行添加逻辑
         */
        public void put(int key, int value) {
            if (kvMap.containsKey(key)) { // 更新逻辑
                Node node = kvMap.get(key);
                int oldFreq = node.freq;
                DoubleLinkedList oldFreqList = freqMap.get(oldFreq);
                oldFreqList.remove(node);
                if (node.freq == minFreq && oldFreqList.isEmpty()) {
                    minFreq++;
                }
                node.freq++;
                int newFreq = node.freq;
                DoubleLinkedList list = freqMap.computeIfAbsent(newFreq, k -> new DoubleLinkedList());
                list.addFirst(node);
                node.value = value; // 更新
            } else { // 添加
                if (kvMap.size() == capacity) { // 容量满了
                    DoubleLinkedList minFreqList = freqMap.get(minFreq);
                    Node removed = minFreqList.removeLast();// 移除使用频率最少，存在时间最长的数据
                    kvMap.remove(removed.key);
                }
                Node node = new Node(key, value);
                kvMap.put(key, node);
                DoubleLinkedList list = freqMap.computeIfAbsent(1, k -> new DoubleLinkedList());
                list.addFirst(node);
                minFreq = 1; // 新添加一个数据后，最小访问频率一定是1
            }
        }

        static class Node {
            private Node prev;
            private Node next;
            private final int key;
            private int value;
            private int freq = 1;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        static class DoubleLinkedList {

            private final Node head;
            private final Node tail;
            private int size;

            public DoubleLinkedList() {
                this.head = new Node(-1, -1);
                this.tail = new Node(-1, -1);
                head.next = tail;
                tail.prev = head;
            }

            // 从链表头部添加
            public void addFirst(Node newFirst) {
                Node oldFirst = head.next;
                newFirst.prev = head;
                newFirst.next = oldFirst;
                head.next = newFirst;
                oldFirst.prev = newFirst;
                size++;
            }

            // 从链表中删除已知节点
            public void remove(Node node) {
                Node next = node.next;
                Node prev = node.prev;
                prev.next = next;
                next.prev = prev;
                size--;
            }

            // 删除链表尾部节点
            public Node removeLast() {
                Node last = tail.prev;
                remove(last);
                return last;
            }

            // 判断链表是否为空
            public boolean isEmpty() {
                return size == 0;
            }
        }

    }
}
