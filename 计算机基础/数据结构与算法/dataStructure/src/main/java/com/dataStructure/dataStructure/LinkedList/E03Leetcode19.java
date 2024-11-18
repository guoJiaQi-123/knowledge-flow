package com.dataStructure.dataStructure.LinkedList;

/**
 * 删除链表的倒数第 N 个结点
 */
public class E03Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);//哨兵
        recursion(s, n);
        return s.next;
    }

    private int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        //nth:当前节点的下一个节点是倒数第几个节点
        int nth = recursion(p.next, n);
        if (nth == n) {
            p.next = p.next.next;
        }
        return nth + 1;
    }

    //删除倒数第n个节点
public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);//哨兵
        ListNode p1 = s;
        ListNode p2 = s;
        //p2先移动n步
        for (int i = 0; i <= n; i++) {
            p2 = p2.next;
        }
        //一起移动，直到p2为空
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        //删除倒数第n个节点
        p1.next = p1.next.next;
        return s.next;
    }
}