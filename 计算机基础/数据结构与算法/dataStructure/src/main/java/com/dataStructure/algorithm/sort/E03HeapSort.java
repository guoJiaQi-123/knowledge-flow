package com.dataStructure.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class E03HeapSort {

    /**
     * 堆排序
     */
    public static void heapSort(int[] a) {
        //建立大顶堆
        heapify(a, a.length);
        for (int right = a.length - 1; right > 0; right--) {
            swap(a, 0, right); //交换堆顶元素到未排序区域的最后一位（将最大值移动到最后）
            down(a, 0, right); //对于堆顶元素进行下潜操作，使其重新符合大顶堆特性
        }
    }


    /**
     * 建推
     */
    private static void heapify(int[] array, int size) {
        /*
                1.找到完全二叉树的最后一个非叶子节点     公式： size / 2 - 1
                2.从后向前，依次对每个非叶子节点调用下潜down方法
         */
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            down(array, i, size);
        }
    }

    /**
     * 下潜 <非递归实现>
     */
    private static void down(int[] array, int parent, int size) {
        /*
               1.找到当前节点的左孩子节点和右孩子节点
               2.将当前节点的值和左孩子，右孩子的值进行比较
               3.定义一个变量max，用于存放当前节点与其左右孩子中最大的值的下标
               4.默认最大值先为当前节点，如果左孩子的值大于当前节点，更新max指针为左孩子下标，右孩子类似
               5.经过比较，如果max指针任然为父节点，说明没有发生交换，已经符合大顶堆特性，退出循环即可
               6.如果max不为父节点，交换当前父节点与max指针指向的节点的值，将max赋值给父节点，循环继续判断是否仍需要下潜
         */
        while (true) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < size && array[left] > array[max]) {
                max = left;
            }
            if (right < size && array[right] > array[max]) {
                max = right;
            }
            // 没有发生交换
            if (max == parent) {
                break;
            }
            swap(array, max, parent);
            parent = max;
        }
    }

    /**
     * 交换
     */
    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] ints = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(ints));
        heapSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
