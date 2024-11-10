package com.tyut.queue;

import java.util.ArrayDeque;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote ArrayDeque方法示例
 */
public class MainArrayDeque {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        //创建一个ArrayDeque实例，存储Integer类型的元素
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();// 复杂度: 0(1)

        //向ArrayDeque添加元素
        arrayDeque.add(10);// 复杂度:0(1)
        arrayDeque.add(20);// 复杂度:0(1)
        arrayDeque.add(30);// 复杂度:0(1)

        //打印ArrayDeque中的元素（按添加顺序排列)
        System.out.println("ArrayDeque:" + arrayDeque);

        //获取ArrayDeque的大小
        int size = arrayDeque.size(); // 复杂度: 0(1)
        System.out.println("Size of ArrayDeque:" + size);

        //检查ArrayDeque是否为空
        boolean isEmpty = arrayDeque.isEmpty();// 复杂度:0(1)
        System.out.println("Is ArrayDeque empty: " + isEmpty);

        //访问ArrayDeque的第一个和最后一个元素
        int firstElement = arrayDeque.getFirst(); // 复杂度: 0(1)
        int lastElement = arrayDeque.getLast(); // 复杂度: 0(1)
        System.out.println("First element: " + firstElement);
        System.out.println("Last element:" + lastElement);

        //弹出（删除）ArrayDeque的第一个和最后一个元素
        int removedFirst = arrayDeque.pollFirst(); // 复杂度: 0(1)
        int removedLast = arrayDeque.pollLast(); // 复杂度: 0(1)
        System.out.println("Removed first element: " + removedFirst);
        System.out.println("Removed last element: " + removedLast);

        //清空ArrayDeque
        arrayDeque.clear();// 复杂度:0(n)
        System.out.println("ArrayDeque after clearing: " + arrayDeque);
    }
}
