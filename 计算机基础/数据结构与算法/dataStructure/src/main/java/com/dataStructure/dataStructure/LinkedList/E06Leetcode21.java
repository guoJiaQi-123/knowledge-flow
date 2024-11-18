package com.dataStructure.dataStructure.LinkedList;

/**
 * 合并两个有序链表
 */
public class E06Leetcode21 {

    //方法一：迭代
    public ListNode mergeTwoLists1(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(-1, null);//新链表的哨兵节点
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

    //方法二：递归
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if(p1==null){
            return p2;
        }
        if(p2==null){
            return p1;
        }

        if(p1.val<p2.val){
            p1.next=mergeTwoLists(p1.next,p2);
            return p1;
        }else {
            p2.next=mergeTwoLists(p1,p2.next);
            return p2;
        }
    }
}
