package com.dataStructure.dataStructure.LinkedList;

/**
 * 判断回文链表
 */
public class E09Leedcode234 {
    /*
        1.找到链表中间节点
        2.反转中间节点以后的链表
        3.将反转后的链表与原来的链表比较
     */
    public boolean isPalindrome(ListNode head) {
        ListNode middle = this.middle(head);//1.找到链表中间节点
        ListNode newHead = this.reverse(middle);//2.反转中间节点以后的链表
        return this.compare(newHead, head);
    }

    //反转后的链表与原来链表做比较
    private boolean compare(ListNode newHead, ListNode head) {

        while (newHead!=null){
            if(newHead.val!=head.val){
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    //反转链表
    private ListNode reverse(ListNode o1) {
        ListNode n1 = null;//反转后的新链表
        while (o1!=null){
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    //返回中间节点：双指针
    private ListNode middle(ListNode p){
        ListNode p1 = p;
        ListNode p2 = p;
        while (p2!=null&&p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }


}

class E09Leedcode234_youhua {
    /*
        1.找到链表中间节点
        2.反转中间节点以后的链表
        3.将反转后的链表与原来的链表比较
     */
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head;//慢指针
        ListNode p2 = head;//快指针
        ListNode n1 = null;//反转后新链表头结点
        ListNode o1 = head;//旧链表的头结点
        while (p2!=null&&p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;

            ListNode o2 = o1.next;//记录旧链表的头结点的下一个节点
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        if(p2!=null){
            p1 = p1.next;
        }

        while (n1 !=null){
            if(n1.val!= p1.val){
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }


}
