package com.dataStructure.dataStructure.priorityqueue;

import com.dataStructure.dataStructure.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class E01Leetcode23 {
    public ListNode mergeKLists(ListNode[] lists) {

        /*              p1
         *          1   5   9   7   null
         *              p2
         *          5   6   8   9   null
         *              p3
         *          3   5   7   8   null
         *
                    小顶堆：   5   5   6
                    空链表     1-3-5

         */

        MinHeap minHeap = new MinHeap(lists.length);
        for (ListNode h : lists) {
            if (h != null) {
                minHeap.offer(h);
            }
        }
        //新链表的哨兵节点
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            p.next = min;
            p = min;

            if(min.next!=null){
                minHeap.offer(min.next);
            }
        }
        return s;
    }
}
