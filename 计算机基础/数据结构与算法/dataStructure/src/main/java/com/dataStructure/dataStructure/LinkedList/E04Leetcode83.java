package com.dataStructure.dataStructure.LinkedList;

/**
 * 删除排序链表中的重复元素
 */
public class E04Leetcode83 {
    //方法一：双指针
    public ListNode deleteDuplicates1(ListNode head) {
        //节点数<2
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);//哨兵节点
        ListNode p1 = s;
        ListNode p2 = p1.next;
        while (p2 != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }

    //代码优化版
    public ListNode deleteDuplicates2(ListNode head) {
        //节点数<2
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);//哨兵节点
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    //方法二：递归
    public ListNode deleteDuplicates(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if(p.val == p.next.val){
            return deleteDuplicates(p.next);
        }else {
            p.next=deleteDuplicates(p.next);
            return p;
        }

    }
}
