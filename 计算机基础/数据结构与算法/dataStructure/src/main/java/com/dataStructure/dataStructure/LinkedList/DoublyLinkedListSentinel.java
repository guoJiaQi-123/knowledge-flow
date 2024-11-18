package com.dataStructure.dataStructure.LinkedList;

import java.util.Iterator;

/**
 * 双向链表（带哨兵）
 */
public class DoublyLinkedListSentinel implements Iterable{
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node pointer = head.next;
            @Override
            public boolean hasNext() {
                return pointer!=tail;
            }

            @Override
            public Object next() {
                int value = pointer.value;
                pointer=pointer.next;
                return value;
            }
        };
    }

    //节点类
    static class Node{
        Node prev;//前一个节点
        int value;
        Node next;//后一个节点

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
    private Node head;//头哨兵
    private Node tail;//尾哨兵

    public DoublyLinkedListSentinel(){
        head = new Node(null,666,null);
        tail = new Node(null,888,null);
        head.next=tail;
        tail.prev=head;
    }


    private Node findNode(int index){
        int i = -1;
        for(Node pointer = head;pointer!=tail;pointer=pointer.next,i++){
            if(i==index){
                return pointer;
            }
        }
        return null;
    }
    public void addFirst(int value){
        insert(0,value);
    }

    public void removeFirst(){
        remove(0);
    }

    public void addLast(int value){
        Node last = tail.prev;
        Node newLasted = new Node(last, value, tail);
        last.next=newLasted;
        tail.prev=newLasted;
    }

    public void removeLast(){
        Node removed = tail.prev;
        if(removed==head){
            throw illegalException(0);
        }
        Node prev = removed.prev;
        prev.next=tail;
        tail.prev=prev;
    }

    public void insert(int index,int value){
        Node prev = findNode(index - 1);
        if(prev==null){
            throw illegalException(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next=inserted;
        next.prev=inserted;
    }

    public void remove(int index){
        Node prev = findNode(index - 1);
        if(prev == null){
            throw illegalException(index);
        }
        Node removed = prev.next;
        if(removed==tail){
            throw illegalException(index);
        }
        Node next = removed.next;
        prev.next=next;
        next.prev=prev;
    }

    private static IllegalArgumentException illegalException(int index) {
        throw new IllegalArgumentException(String.format("index[%d]"+ index +"不合法"));
    }


}
