package com.dataStructure.dataStructure.circular;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 环形链表
 */
public class DoublyLinkedListSentinelTest {

    @Test
    public void testAddFirst(){
        DoublyLinkedListSentinel linkedList = new DoublyLinkedListSentinel();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);

        assertIterableEquals(List.of(5,4,3,2,1), linkedList);
    }
    @Test
    public void testAddLast(){
        DoublyLinkedListSentinel linkedList = getList();

        assertIterableEquals(List.of(1,2,3,4,5), linkedList);
    }

    private static DoublyLinkedListSentinel getList() {
        DoublyLinkedListSentinel linkedList = new DoublyLinkedListSentinel();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        return linkedList;
    }

    @Test
    public void testRemoveFirst(){
        DoublyLinkedListSentinel list = getList();
        list.removeFirst();
        assertIterableEquals(List.of(2,3,4,5),list);
        list.removeFirst();
        assertIterableEquals(List.of(3,4,5),list);
        list.removeFirst();
        assertIterableEquals(List.of(4,5),list);
        list.removeFirst();
        assertIterableEquals(List.of(5),list);

    }
    @Test
    public void testRemoveLast(){
        DoublyLinkedListSentinel list = getList();
        list.removeLast();
        assertIterableEquals(List.of(1,2,3,4),list);
        list.removeLast();
        assertIterableEquals(List.of(1,2,3),list);
        list.removeLast();
        assertIterableEquals(List.of(1,2),list);
        list.removeLast();
        assertIterableEquals(List.of(1),list);
        list.removeLast();
        assertIterableEquals(List.of(),list);
        assertThrows(IllegalArgumentException.class,list::removeLast);
    }

    @Test
    public void testRemoveByValue(){
        DoublyLinkedListSentinel list = getList();
        list.removeByValue(1);
        assertIterableEquals(List.of(2,3,4,5),list);
        list.removeByValue(2);
        assertIterableEquals(List.of(3,4,5),list);
        list.removeByValue(3);
        assertIterableEquals(List.of(4,5),list);
        list.removeByValue(4);
        assertIterableEquals(List.of(5),list);
        list.removeByValue(5);
        assertIterableEquals(List.of(),list);
        list.removeByValue(6);
        assertIterableEquals(List.of(),list);
    }
}
