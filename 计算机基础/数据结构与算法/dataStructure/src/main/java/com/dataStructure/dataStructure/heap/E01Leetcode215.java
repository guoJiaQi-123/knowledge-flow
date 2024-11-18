package com.dataStructure.dataStructure.heap;

import java.util.PriorityQueue;

/**
 * <h3>求数组中第 K 大的元素 - 小顶堆</h3>
 * <p>
 * 思路
 * <ol>
 *     <li>向小顶堆放入前k个元素</li>
 *     <li>剩余元素</li>
 *     <ul>
 *         <li>若 <= 堆顶元素, 则略过</li>
 *         <li>若 > 堆顶元素, 则替换堆顶元素</li>
 *     </ul>
 *     <li>这样小顶堆始终保留的是到目前为止, <b>前 K 大</b>的元素</li>
 *     <li>循环结束, 堆顶元素即为<b>第 K 大</b>元素</li>
 *     <li>时间复杂度 O(n*log(n))</li>
 * </ol>
 */
public class E01Leetcode215 {
    public int findKthLargest(int[] nums, int k) {

        MinHeap heap = new MinHeap(k);
        // 先把前k个元素加入小顶堆
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            // 如果后面的元素有比堆顶元素大的，则替换堆顶元素
            if (nums[i] > heap.peek()) {
                heap.replace(nums[i]);
            }
        }
        // 最后堆顶元素就是第K大元素
        return heap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 先把前k个元素加入小顶堆
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            // 如果后面的元素有比堆顶元素大的，则替换堆顶元素
            if (nums[i] > minHeap.peek()) {
                minHeap.remove(minHeap.peek());
                minHeap.offer(nums[i]);
            }
        }
        // 最后堆顶元素就是第K大元素
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        E01Leetcode215 e01Leetcode215 = new E01Leetcode215();
        int kthLargest = e01Leetcode215.findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }
}
