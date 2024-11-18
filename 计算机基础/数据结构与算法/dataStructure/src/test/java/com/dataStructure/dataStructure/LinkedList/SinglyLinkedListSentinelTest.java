package com.dataStructure.dataStructure.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListSentinelTest {


    private SinglyLinkedListSentinel getLinkedList(){
        SinglyLinkedListSentinel list = new SinglyLinkedListSentinel();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        return list;
    }


    @Test
    public void test1(){
        SinglyLinkedListSentinel linkedList = getLinkedList();
        for (Integer i : linkedList) {
            System.out.println(i);
        }
    }

    //测试get
    @Test
    public void test2(){
        SinglyLinkedListSentinel linkedList = getLinkedList();
        int i = linkedList.get(3);
        System.out.println(i);
    }

    //测试insert
    @Test
    public void test3(){
        SinglyLinkedListSentinel linkedList = getLinkedList();
        linkedList.insert(0,0);
        for (Integer i : linkedList) {
            System.out.println(i);
        }
    }

    //测试remove
    @Test
    public void test4(){
        SinglyLinkedListSentinel linkedList = getLinkedList();
        int index = 0;
        linkedList.remove(index);
        for (Integer i : linkedList) {
            System.out.println(i);
        }
    }

    //测试递归遍历
    @Test
    public void test5(){
        SinglyLinkedListSentinel linkedList = getLinkedList();
        linkedList.loop3(value -> System.out.println("before:"+value),
                        value -> System.out.println("after:"+value));
    }
}
