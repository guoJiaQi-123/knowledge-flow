package com.dataStructure.dataStructure.LinkedList;

//删除排序链表中的重复元素 II（重复元素一个不留）
public class E05Leetcode82 {

    //方法一：递归
    public ListNode deleteDuplicates1(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode p1 = p.next.next;
            while (p1 != null && p1.val == p.val) {
                p1 = p1.next;
            }
            return deleteDuplicates(p1);
        }else {
            p.next=deleteDuplicates(p.next);
            return p;
        }
    }

    //方法二：非递归，三指针
    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1,head);//哨兵节点
        ListNode p1 = s;
        ListNode p2,p3;
        while ((p2 = p1.next)!=null&&(p3=p2.next)!=null){
            if(p2.val==p3.val){
                while ((p3 = p3.next)!=null&&p3.val==p2.val){}
                p1.next=p3;
            }else {
                p1 = p1.next;
            }
        }
        return s.next;
    }

    //方法三：一次遍历
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1,head);//哨兵节点
        ListNode cur = s;
        while (cur.next != null && cur.next.next != null){
            if(cur.next.val==cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return s.next;
    }
}
