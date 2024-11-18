package com.dataStructure.dataStructure.queue;

import java.util.Iterator;

/**
 * 单向环形带哨兵 链表方式来实现队列
 */
public class LinkedListQueue<E> implements Queue<E>, Iterable<E> {


    //节点类
    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    //头指针
    private Node<E> head = new Node<>(null, null);//初始化：头指针指向实例化的哨兵节点
    //尾指针
    private Node<E> tail = head;
    //节点个数
    private int size;
    //队列容量，默认为无限
    private int capacity = Integer.MAX_VALUE;

    {
        tail.next = head;//静态初始化块中，将尾节点的next指向头节点，实现循环
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }//有参构造，参数为队列容量

    public LinkedListQueue() {}//无参构造

    @Override       //向队列尾部添加节点
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        Node<E> added = new Node<>(value, head);//实例化待插入的节点对象
        tail.next = added;//将尾指针的next指向新节点
        tail = added;//将尾指针指向新节点
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail) {
            tail = head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    /**
     * 迭代器方法
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;//从哨兵的next开始迭代

            @Override
            public boolean hasNext() {
                return p != head;//因为是循环队列，所有当指针不为头指针时，说明迭代没有完成，返回true
            }

            @Override
            public E next() {
                E value = p.value;//记录指针所指节点的值
                p = p.next;//移动指针
                return value;//返回值
            }
        };
    }
}
