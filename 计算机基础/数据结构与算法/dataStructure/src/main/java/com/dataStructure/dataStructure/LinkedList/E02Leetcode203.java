package com.dataStructure.dataStructure.LinkedList;

/**
 * 移除链表元素
 */
public class E02Leetcode203 {

    //方法一，定义两个指针循环遍历链表
    public ListNode removeElements1(ListNode head, int val) {
        ListNode s = new ListNode(666, head);//哨兵节点
        ListNode p1 = s;
        ListNode p2 = p1.next;
        while (p2 != null) {
            if (p2.val == val) {
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
    public ListNode removeElements2(ListNode head, int val) {
        ListNode s = new ListNode(666, head);//哨兵节点
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p2.val == val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    public ListNode removeElements(ListNode head, int val) {
        //如果头节点为空，则返回空
        if (head == null) {
            return null;
        }

        //如果头节点的值等于val，则返回移除头节点之后的链表
        if (head.val == val) {
            return removeElements(head.next, val);
            //否则，将头节点的下一个节点作为头节点，并递归调用removeElements函数，返回头节点
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 6, 3, 6);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new E02Leetcode203()
                .removeElements(head, 6));
    }

}

