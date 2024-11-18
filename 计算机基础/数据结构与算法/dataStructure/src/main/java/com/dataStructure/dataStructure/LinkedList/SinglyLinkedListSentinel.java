package com.dataStructure.dataStructure.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表 （带哨兵）
 */
public class SinglyLinkedListSentinel implements Iterable<Integer> {
    //头指针   指向哨兵节点
    private Node head = new Node(666, null);


    /**
     * 向链表头部添加
     *
     * @param value 待添加的值
     */
    public void addFirst(int value) {
        //1.链表为空
//        head = new Node(value,null);   可以合并
        //2.链表非空
        insert(0, value);
    }

    /**
     * 向链表的尾部添加元素
     *
     * @param value 待添加的元素
     */
    public void addLast(int value) {
        //1.先找到最后一个节点
        Node last = findLast();

        last.next = new Node(value, null);


    }

    private Node findLast() {
        Node pointer = head;

        while (pointer.next != null) {
            pointer = pointer.next;
        }
        return pointer;
    }


    /**
     * 根据索引获取元素
     *
     * @param index 索引值
     * @return 该索引对应的节点数据
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw IllegalIndex(index);
        }
        return node.value;
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node pointer = head; pointer != null; pointer = pointer.next, i++) {
            if (i == index) {
                return pointer;
            }
        }
        return null;
    }

    /**
     * 根据索引插入
     *
     * @param index 索引
     * @param value 插入元素的值
     */
    public void insert(int index, int value) {

        Node prev = findNode(index - 1);
        if (prev == null) {
            IllegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    //索引不合法异常
    private IllegalArgumentException IllegalIndex(int index) {
        throw new IllegalArgumentException
                (String.format("index [%d] 不合法%n", index));
    }

    /**
     * 删除链表的第一个节点
     */
    public void removeFirst() {
        if (head == null) {
            throw IllegalIndex(0);
        }
        head = head.next;
    }

    /**
     * 根据索引删除元素
     *
     * @param index 索引
     */
    public void remove(int index) {

        Node prev = findNode(index - 1);//找到上一个节点
        if (prev == null) {
            throw IllegalIndex(index);
        }
        Node removed = prev.next;//被删除节点
        if (removed == null) {
            throw IllegalIndex(index);
        }
        prev.next = removed.next;
    }

    /**
     * while循环遍历链表
     */
    public void loop1(Consumer<Integer> consumer) {
        Node pointer = head.next;
        while (pointer != null) {
            consumer.accept(pointer.value);
            pointer = pointer.next;
        }
    }

    /**
     * for循环遍历链表
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node pointer = head.next; pointer != null; pointer = pointer.next) {
            consumer.accept(pointer.value);
        }
    }

    /**
     * Iterator迭代器循环链表
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head.next;

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    /**
     * 递归遍历链表
     */
    public void loop3(Consumer<Integer> before, Consumer<Integer> after) {
        recursion(head.next, before, after);
    }

    /**
     * 递归函数
     */
    private void recursion(Node node, Consumer<Integer> before, Consumer<Integer> after) {
        if (node == null) {
            return;
        }
        before.accept(node.value);
        recursion(node.next, before, after);
        after.accept(node.value);
    }

    /**
     * 节点类
     */
    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
