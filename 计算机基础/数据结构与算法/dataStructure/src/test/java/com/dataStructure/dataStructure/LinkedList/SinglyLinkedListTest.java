package com.dataStructure.dataStructure.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    //测试while循环遍历链表
    @Test
    public void test1(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        //singlyLinkedList.loop1(value-> System.out.println(value));
        singlyLinkedList.loop1(System.out::println);
    }

    //测试for循环遍历链表
    @Test
    public void test2(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        singlyLinkedList.loop2(System.out::println);
    }

    //测试Iterator迭代器遍历链表
    @Test
    public void test3(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }

    //测试addLast向链表尾部添加元素
    @Test
    public void test4(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }

    //测试get
    @Test
    public void test5(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        int i = singlyLinkedList.get(2);
        Assert.assertEquals(3,i);
    }

    //测试insert
    @Test
    public void test6(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.insert(4,5);
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }

    //测试removeFirst
    @Test
    public void test7(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.removeFirst();
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }

        System.out.println("============");

        singlyLinkedList.removeFirst();
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }

        System.out.println("============");

        singlyLinkedList.removeFirst();
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
        System.out.println("============");

        singlyLinkedList.removeFirst();
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }

    }

    //测试remove
    @Test
    public void test8(){
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.remove(3);
        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }
}
