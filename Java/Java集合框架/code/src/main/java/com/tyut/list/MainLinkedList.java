package com.tyut.list;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote LinkedList实例
 */
public class MainLinkedList {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //创建一个LinkedList实例，存储String类型的元素
        LinkedList<String> linkedList = new LinkedList<>(); // 复杂度: O(1)

        //向LinkedList添加元素
        linkedList.add("Apple");// 复杂度:0(1)
        linkedList.add("Banana");// 复杂度:0(1)
        linkedList.add("cherry"); // 复杂度: 0(1)

        //打印LinkedList中的元素
        System.out.println("LinkedList: " + linkedList);

        //获取LinkedList的大小
        int size = linkedList.size(); // 复杂度:0(1)
        System.out.println("Size of LinkedList: " + size);

        //检查LinkedList是否为空
        boolean isEmpty = linkedList.isEmpty(); // 复杂度: 0(1)
        System.out.println("Is LinkedList empty: " + isEmpty);

        //访问特定位置的元素（使用ListIterator遍历）
        ListIterator<String> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();// 复杂度: 0(1)
            System.out.println("Element:" + element);
        }

        //修改特定位置的元素
        linkedList.set(2, "Grapes");// 复杂度：0(n)
        System.out.println("LinkedList after updating: " + linkedList);

        //检查LinkedList中是否包含某个元素
        boolean contains = linkedList.contains("Banana"); // 复杂度: O(n)
        System.out.println("LinkedList contains 'Banana': " + contains);

        //移除指定位置的元素
        linkedList.remove(0);// 复杂度:0(n)
        System.out.println("LinkedList after removing at index 0: " + linkedList);

        //清空LinkedList
        linkedList.clear();// 复杂度：0(n)
        System.out.println("LinkedList after clearing: " + linkedList);
    }
}
