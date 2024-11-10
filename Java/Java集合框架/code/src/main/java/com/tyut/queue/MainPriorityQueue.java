package com.tyut.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote PriorityQueue方法示例
 */
public class MainPriorityQueue {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //创建一个PriorityQueue实例，存储整数类型的元素
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder()); // 默认为最小堆

        //添加元素到PriorityQueue
        priorityQueue.offer(5);//将元素插入队列，时间复杂度：0(Logn)
        priorityQueue.offer(2);
        priorityQueue.offer(8);
        priorityQueue.offer(1);
        priorityQueue.offer(10);

        //获取队列的头部元素 (最小值)
        int head = priorityQueue.peek();// 获取队列头部元素，时间复杂度：0(1)
        System.out.println("Head of the PriorityQueue: " + head);

        //删除队列的头部元素
        int removed = priorityQueue.poll();// 删除队列头部元素，时间复杂度：0(Log n)
        System.out.println("Removed element from the PriorityQueue: " + removed);

        //打印priorityQueue中的所有元素
        System.out.println("Elements in the PriorityQueue:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
