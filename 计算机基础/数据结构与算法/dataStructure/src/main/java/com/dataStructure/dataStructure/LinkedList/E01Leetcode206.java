package com.dataStructure.dataStructure.LinkedList;

import java.security.Key;

/**
 * 反转链表
 */
public class E01Leetcode206 {//方法一：双指针

    // 方法1
    //反转链表
    public ListNode reverseList1(ListNode o1) {
        ListNode n1 = null;//新链表的头节点
        ListNode p = o1;//原来链表的头结点
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    //方法2 面向对象，List类在最下方
    public ListNode reverseList2(ListNode o1) {
        //创建一个链表，将o1的值赋值给链表
        List list_old = new List(o1);
        //创建一个新的链表，初始头节点为null
        List list_new = new List(null);
        //当链表头节点不为空时，循环
        while (list_old.head != null) {
            //将链表头节点删除，并赋值给headList
            ListNode headList = list_old.removeHeadList();
            //将headList添加到新链表的头部
            list_new.addHeadList(headList);
        }
        //返回新链表的头节点
        return list_new.head;
    }

    //方法3 - 递归
    // 递归调用reverseList函数，传入参数o1.next，返回反转后的链表
    public ListNode reverseList3(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }

        ListNode last = reverseList(o1.next);
        o1.next.next = o1;
        o1.next = null;
        return last;
    }

    //方法4
    public ListNode reverseList4(ListNode o1) {
        //判断边界   1.空链表   2.只有一个节点的链表   ->都将o1输出即可
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while (o2 != null) {
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    //方法5
    public ListNode reverseList(ListNode o1) {
        //判断边界条件 1.链表为空   2.链表只有一个节点
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;

    }

    //链表
    static class List {
        //链表头节点
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        /**
         * 链表头部添加节点
         *
         * @param node 待添加节点
         */
        public void addHeadList(ListNode node) {
            //将添加的节点指向链表头节点
            node.next = head;
            //将添加的节点赋值给链表头节点
            head = node;
        }

        /**
         * 链表头部删除节点
         *
         * @return 删除的节点
         */
        public ListNode removeHeadList() {
            //将链表头节点赋值给head_old
            ListNode head_old = head;
            //当链表头节点不为空时，循环
            if (head_old != null) {
                //将链表头节点指向下一个节点
                head = head_old.next;
            }
            //返回删除的节点
            return head_old;
        }
    }


}



