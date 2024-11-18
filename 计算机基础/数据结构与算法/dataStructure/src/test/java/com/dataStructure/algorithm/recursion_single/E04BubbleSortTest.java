package com.dataStructure.algorithm.recursion_single;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class E04BubbleSortTest {

    @Test
    @DisplayName("测试递归实现冒泡排序")
    public void test1(){
        int[] exception = {1,2,3,4,5};
        int[] arr1 ={5,2,4,3,1};
        E04BubbleSort.sort(arr1);
        Assert.assertArrayEquals(exception,arr1);

        int[] arr2 ={1,5,4,3,2};
        E04BubbleSort.sort(arr2);
        Assert.assertArrayEquals(exception,arr2);

        int[] arr3 ={5,4,2,1,3};
        E04BubbleSort.sort(arr3);
        Assert.assertArrayEquals(exception,arr3);

        int[] arr4 ={5,4,3,2,1};
        E04BubbleSort.sort(arr4);
        Assert.assertArrayEquals(exception,arr4);

    }
}
