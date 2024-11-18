package com.dataStructure.algorithm.recursion_single;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class E03BinarySearchTest {

    @Test
    @DisplayName("测试递归实现的二分查找")
    public void test1(){
        int[] arr=new int[]{12,14,16,25,35,62,67,75};
        E03BinarySearch e03BinarySearch = new E03BinarySearch();
        Assert.assertEquals(0,e03BinarySearch.search(arr,12));
        Assert.assertEquals(1,e03BinarySearch.search(arr,14));
        Assert.assertEquals(2,e03BinarySearch.search(arr,16));
        Assert.assertEquals(3,e03BinarySearch.search(arr,25));
        Assert.assertEquals(4,e03BinarySearch.search(arr,35));
        Assert.assertEquals(5,e03BinarySearch.search(arr,62));
        Assert.assertEquals(6,e03BinarySearch.search(arr,67));
        Assert.assertEquals(7,e03BinarySearch.search(arr,75));

        Assert.assertEquals(-1,e03BinarySearch.search(arr,15));
        Assert.assertEquals(-1,e03BinarySearch.search(arr,745));
    }
}
