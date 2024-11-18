package com.dataStructure.dataStructure.LinkedList;

/**
 * 删除节点
 */
public class E12Leetcode237 {
    //删除节点
    public void deleteNode(ListNode node) {
        //将下一个节点的值赋值给当前节点
        node.val = node.next.val;
        //将下一个节点的指针赋值给当前节点
        node.next = node.next.next;
    }
}
