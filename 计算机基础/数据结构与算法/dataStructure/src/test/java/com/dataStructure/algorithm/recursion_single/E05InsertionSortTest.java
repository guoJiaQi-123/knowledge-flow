package com.dataStructure.algorithm.recursion_single;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class E05InsertionSortTest {


    @Test
    @DisplayName("测试递归法实现的插入排序")
    void testInsertionSort(){
        int[] exception = new int[]{1,2,3,4,5,6};
        int[] arr = new int[]{6,5,2,3,1,4};
        E05InsertionSort.sort(arr);
        Assert.assertArrayEquals(exception,arr);

        int[] arr2 = new int[]{3,1,2,5,4,6};
        E05InsertionSort.sort(arr2);
        Assert.assertArrayEquals(exception,arr2);

        int[] arr3 = new int[]{6,5,4,3,2,1};
        E05InsertionSort.sort(arr3);
        Assert.assertArrayEquals(exception,arr3);

        int[] arr4 = new int[]{5,2,3,4,6,1};
        E05InsertionSort.sort(arr4);
        Assert.assertArrayEquals(exception,arr4);
    }

}
