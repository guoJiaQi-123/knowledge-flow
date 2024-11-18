package com.dataStructure.algorithm.divideandconquer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author OldGj 2024/02/27
 * @version v1.0
 * @apiNote 快速选择算法  时间复杂度 ： O(n)
 */
public class QuickSelect {

    public static void main(String[] args) {
        int[] array = {6, 5, 1, 2, 4};
        System.out.println(quickSelect(array, 0, array.length - 1, 0)); // 1
        System.out.println(quickSelect(array, 0, array.length - 1, 1)); // 2
        System.out.println(quickSelect(array, 0, array.length - 1, 2)); // 4
        System.out.println(quickSelect(array, 0, array.length - 1, 3)); // 5
        System.out.println(quickSelect(array, 0, array.length - 1, 4)); // 6
    }

    public static int quickSelect(int[] arrays, int left, int right, int index) {
        int p = partition3(arrays, left, right);
        if (index == p) {
            return arrays[p];
        }
        if (index < p) {
            return quickSelect(arrays, left, p - 1, index);
        } else {
            return quickSelect(arrays, p + 1, right, index);
        }
    }

    /**
     * lomuto 分区方法
     * 核心思想：每轮找一个基准点元素，比基准点元素小的放到它左边，比基准点元素大的放到它右边，这称为分区
     * 1. 选择最右元素作为基准点元素
     * 2. j 找比基准点小的，i找比基准点大的，一旦找到，二者进行交换。
     * * 交换时机：j 找到小的，且与 i 不相等
     * * i 找到 >= 基准点元素后，不应自增
     * 3. 最后基准点与 i 交换，i 即为基准点最终索引
     */
    private static int partition(int[] arrays, int left, int right) {
        int pv = arrays[right];
        int i = left;
        int j = left;
        while (j < right) {
            if (arrays[j] < pv) {
                if (i != j) {
                    swap(arrays, i, j);
                }
                i++;
            }
            j++;
        }
        swap(arrays, i, right);
        return i;
    }

    /**
     * 分区方法2：
     * 1. 选择最左侧元素作为基准点元素
     * 2. j 指针负责从右向左找比基准点小或等的元素， i 指针负责从左向右找比基准点大的元素
     * 一旦找到两者交换，直至 i 与 j 相交。
     * 3. 最后基准点与 i (此时 i 与 j 相等 )交换，i 即为分区位置
     */
    private static int partition2(int[] a, int left, int right) {
        int pv = a[left]; // 最左侧元素作为基准点
        int i = left; // i 从左向右找大的
        int j = right; // j 从右向左找小的
        while (i < j) {
            while (i < j && a[j] > pv) {
                j--;
            }
            while (i < j && a[i] <= pv) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, left, i);
        return i;
    }

    /*
        分区方法3： 处理相等元素
            循环内
                i 从 left + 1 开始，从左向右找大的或相等的
                j 从 right 开始，从右向左找小的或相等的
                交换，i++ j--

            循环外 j 和 基准点交换，j 即为分区位置
    */
    private static int partition3(int[] a, int left, int right) {
        //随机基准值
        int index = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        swap(a,index,left);

        int pv = a[left]; // 基准点
        int i = left + 1; // i 从左向右找大的
        int j = right; // j 从右向左找小的
        //处理重复值
        while (i <= j) {
            // i 从左向右找大的或者相等的
            while (i <= j && a[i] < pv) {
                i++;
            }
            // j 从右向左找小的或者相等的
            while (i <= j && a[j] > pv) {
                j--;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, left, j);
        return j;
    }

    private static void swap(int[] arrays, int i, int j) {
        int t = arrays[j];
        arrays[j] = arrays[i];
        arrays[i] = t;
    }


}
