package com.dataStructure.dataStructure.heap;

import java.util.Arrays;

/**
 * 数据流中的中位数
 */
@SuppressWarnings("all")
public class E03Leetcode295 {

    private Heap left= new Heap(10, true);
    private Heap right= new Heap(10, false);

    /*
            1.            1   3   5   <->    7    9   10
                  先将数据流分为上述两部分，其中左边是一个大顶堆，右边是一个小顶堆
                  两部分在保持个数之差不大于1的情况下，数据流中的中位数就是
                        如果两部分元素个数相等 = (大顶堆中的堆顶元素+小顶堆中的堆顶元素)/2
                        如果两部分元素个数不等 = 大顶堆中的堆顶元素（后面讲原因）

                  如何保证两部分元素个数之差不大于1呢？
                        我们规定,当添加元素时,如果两部分元素个数相等，则将左部分（大顶堆）中个数加一
                                           如果两部分元素个数不相等，则将右部分（小顶堆）中个数加一

                  如何将新元素正确加入到两个堆中呢？
                        我们规定，如果如果两部分元素个数相等，先将元素加入到右部分，再从右部分中拿出最小的元素加入到左部分
                                 如果两部分元素个数不相等，先将元素加入到左部分，再从左部分中拿出最大的元素加入到右部分
    */

    //添加元素
    public void addNum(int num) {
        if (left.getSize() == right.getSize()) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
    }


    //返回中位数
    public double findMedian() {
        if (left.getSize() == right.getSize()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }
}
