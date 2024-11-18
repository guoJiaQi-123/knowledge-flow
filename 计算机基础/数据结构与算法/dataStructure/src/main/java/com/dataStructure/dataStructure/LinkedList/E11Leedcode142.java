package com.dataStructure.dataStructure.LinkedList;

//判断环形链表（找入环点）
public class E11Leedcode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;//兔子
        ListNode p2 = head;//乌龟
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
            if (p2 == p1) {
                p2 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
