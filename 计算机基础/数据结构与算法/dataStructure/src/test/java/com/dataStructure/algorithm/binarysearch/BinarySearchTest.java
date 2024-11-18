package com.dataStructure.algorithm.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    //测试基础版二分查找
    @Test
    public void binarySearchBasic(){
        int[] arr=new int[]{20,52,74,85,99};
        Assert.assertEquals(0,BinarySearch.binarySearchBasic(arr,20));
        Assert.assertEquals(1,BinarySearch.binarySearchBasic(arr,52));
        Assert.assertEquals(2,BinarySearch.binarySearchBasic(arr,74));
        Assert.assertEquals(3,BinarySearch.binarySearchBasic(arr,85));
        Assert.assertEquals(4,BinarySearch.binarySearchBasic(arr,99));

    }
    //测试更新版二分查找
    @Test
    public void testBinarySearchAlternative(){
        int[] arr=new int[]{20,52,74,85,99};
        Assert.assertEquals(0,BinarySearch.binarySearchAlternative(arr,20));
        Assert.assertEquals(1,BinarySearch.binarySearchAlternative(arr,52));
        Assert.assertEquals(2,BinarySearch.binarySearchAlternative(arr,74));
        Assert.assertEquals(3,BinarySearch.binarySearchAlternative(arr,85));
        Assert.assertEquals(4,BinarySearch.binarySearchAlternative(arr,99));
    }

    //测试查找最左边的目标元素
    @Test
    public void testBinarySearchLeftMost(){
        int[] arr=new int[]{4,5,9,12,32,32,34,35,65,65};
        Assert.assertEquals(0,BinarySearch.binarySearchLeftMost1(arr,4));
        Assert.assertEquals(1,BinarySearch.binarySearchLeftMost1(arr,5));
        Assert.assertEquals(2,BinarySearch.binarySearchLeftMost1(arr,9));
        Assert.assertEquals(3,BinarySearch.binarySearchLeftMost1(arr,12));
        Assert.assertEquals(4,BinarySearch.binarySearchLeftMost1(arr,32));
        Assert.assertEquals(6,BinarySearch.binarySearchLeftMost1(arr,34));
        Assert.assertEquals(7,BinarySearch.binarySearchLeftMost1(arr,35));
        Assert.assertEquals(8,BinarySearch.binarySearchLeftMost1(arr,65));
        Assert.assertEquals(-1,BinarySearch.binarySearchLeftMost1(arr,100));
        Assert.assertEquals(-1,BinarySearch.binarySearchLeftMost1(arr,1000));
    }

}
