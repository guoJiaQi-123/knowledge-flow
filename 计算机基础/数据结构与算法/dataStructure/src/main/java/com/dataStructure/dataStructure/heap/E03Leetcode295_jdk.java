package com.dataStructure.dataStructure.heap;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 使用jdk自带的 PriorityQueue对象实现 大小顶堆
 */
@SuppressWarnings("all")
public class E03Leetcode295_jdk {

    private PriorityQueue<Integer> maxQue;
    private PriorityQueue<Integer> minQue;

    public E03Leetcode295_jdk() {
        // 大顶堆
        maxQue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
//      maxQue = new PriorityQueue<>((a, b) -> (a - b));

        // 小顶堆（默认）
        minQue = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
//      minQue = new PriorityQueue<>((a, b) -> (b - a));
    }
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
        if (maxQue.size() == minQue.size()) {
            minQue.offer(num);
            maxQue.offer(minQue.poll());
        } else {
            maxQue.offer(num);
            minQue.offer(maxQue.poll());
        }
    }


    //返回中位数
    public double findMedian() {
        if (maxQue.size() == minQue.size()) {
            return (maxQue.peek() + minQue.peek()) / 2.0;
        } else {
            return maxQue.peek();
        }
    }
}
