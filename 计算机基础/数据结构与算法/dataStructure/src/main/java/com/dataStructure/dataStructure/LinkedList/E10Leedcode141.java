package com.dataStructure.dataStructure.LinkedList;

//判断环形链表
public class E10Leedcode141 {
    //思路：每次乌龟走一步，兔子走两步，如果兔子能追上乌龟，则证明链表中有环存在，否则当兔子走到链表尽头，则证明无环存在
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;//乌龟
        ListNode p2 = head;//兔子
        while (p2 != null && p2.next != null) {
            p2 = p2.next.next;
            p1 = p1.next;
            if (p2 == p1) {
                return true;
            }
        }
        return false;
    }
}