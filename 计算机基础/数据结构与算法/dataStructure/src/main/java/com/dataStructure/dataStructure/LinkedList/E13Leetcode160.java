package com.dataStructure.dataStructure.LinkedList;

/**
 * 相交链表
 */
public class E13Leetcode160 {
    // 获取相交节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 定义两个指针p1和p2，分别指向headA和headB
        ListNode p1 = headA;
        ListNode p2 = headB;
        // 循环遍历，当p1和p2相等时，返回p1
        while (true) {
            if (p1 == p2) {
                return p1;
            }

            // 如果p1指向空，则指向headB
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            // 如果p2指向空，则指向headA
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
    }
}
