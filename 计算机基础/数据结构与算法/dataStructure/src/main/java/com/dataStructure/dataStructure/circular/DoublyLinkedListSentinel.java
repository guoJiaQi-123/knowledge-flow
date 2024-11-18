package com.dataStructure.dataStructure.circular;

import java.util.Iterator;

/**
 * 双向环形链表
 */
public class DoublyLinkedListSentinel implements Iterable{
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Object next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    /**
     * 节点内部类
     */
    static class Node{
        Node prev;
        int value;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    //哨兵节点
    private Node sentinel = new Node(null,-1,null);

    public DoublyLinkedListSentinel() {
        sentinel.prev=sentinel;
        sentinel.next=sentinel;
    }

    public void addFirst(int value){
        Node a = sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next=added;
        b.prev=added;
    }

    public void addLast(int value){
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a, value, b);
        a.next=added;
        b.prev=added;
    }

    public void removeFirst(){
        Node a =sentinel;
        Node removed = sentinel.next;
        if(removed==sentinel){
            throw  new IllegalArgumentException("非法");
        }
        Node b = removed.next;
        a.next=b;
        b.prev=a;
    }

    public void removeLast(){
        Node removed = sentinel.prev;
        if(removed==sentinel){
            throw  new IllegalArgumentException("非法");
        }
        Node a = removed.prev;
        Node b =sentinel;
        a.next = b;
        b.prev = a;
    }

    public void removeByValue(int value){
        int i =0;
        for(Node pointer =sentinel.next;pointer!=sentinel;pointer=pointer.next,i++){
            if(pointer.value==value){
                Node prev = pointer.prev;
                Node next = pointer.next;
                prev.next=next;
                next.prev=prev;
            }
        }
    }
}
