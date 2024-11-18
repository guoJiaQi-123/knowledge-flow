package com.dataStructure.dataStructure.LinkedList;

/**
 * 合并多个有序链表
 */
public class E07Leetcode23 {

    //分治思想：多路递归
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode node = split(lists, 0, lists.length - 1);
        return node;
    }

    //返回合并后的链表
    private ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergeTowLists(left, right);
    }

    //合并两个链表 方法一：递归
    private ListNode mergeTowLists(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }

        if (p1.val < p2.val) {
            p1.next = mergeTowLists(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTowLists(p1, p2.next);
            return p2;
        }

    }

    //合并两个链表 方法二：迭代
    private ListNode mergeTowLists2(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return s.next;
    }
}
