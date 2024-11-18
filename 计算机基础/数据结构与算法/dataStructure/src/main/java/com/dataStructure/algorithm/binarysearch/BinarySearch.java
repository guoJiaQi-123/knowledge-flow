package com.dataStructure.algorithm.binarysearch;

import java.util.Arrays;

public class BinarySearch {
    /**
     * 基础二分查找(前提是：原数组为有序数组)【左闭右闭】
     *
     * @param arr    查找数组
     * @param target 目标
     * @return 目标在数组中的索引下标
     * 没找到返回-1
     */
    public static int binarySearchBasic(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;// 设置指针和初值
        while (i <= j) {                   // i~j 范围内有东西
            //int m = (i + j) / 2;
            int m = (i + j) >>> 1;
            if (target < arr[m]) {         // 目标在左边
                j = m - 1;
            } else if (arr[m] < target) { // 目标在右边
                i = m + 1;
            } else {                    // 找到了
                return m;
            }
        }
        return -1;
    }

    /**
     * 改进版二分查找【左闭右开】
     *
     * @param arr    查找数组
     * @param target 目标
     * @return 目标在数组中的索引下标
     * 没找到返回-1
     */
    public static int binarySearchAlternative(int[] arr, int target) {
        int i = 0;
        int j = arr.length;         //第一处改动   让j指针指向的数据不参与比较

        while (i < j) {              //第二处改动
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m;              //第三处改动
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        //没找到
        return -1;
    }

    /**
     * 二分查找平衡版
     */
    public static int binarySearchBalance(int[] arr, int target) {
        int i = 0;
        int j = arr.length;
        while (j - i > 1) {                    //如果两边界中间任然有待查找元素则继续查找
            int m = (j + i) >>> 1;
            if (target < arr[m]) {
                j = m;
            } else {
                i = m;                     //如果目标大于或等于arr[m]，都将m赋值给i，因为i对应的元素仍然有可能是目标
            }
        }
        //上述循环全部执行后，判断数组中留着的最后一个元素是否为目标，如何是，则找到，如何不是，则数组中并没有目标元素
        if (target == arr[i]) {
            return i;
        } else {
            return -1;
        }
    }

    /**
     * 二分查找LeftMost 查找目标元素的最左边一个
     *
     * @param arr    待查找数组
     * @param target 待查找目标值
     * @return 如果找到，返回目标值最靠左的索引
     * 如果没找到，返回-1
     */
    public static int binarySearchLeftMost1(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else { // 在找到目标元素后，在左半部分继续查找
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找RightMost
     *
     * @param arr    待查找数组
     * @param target 待查找目标值
     * @return 如果找到，返回目标值最靠右的索引
     * 如果没找到，返回-1
     */
    public static int binarySearchRightMost1(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            } else {
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找LeftMost2
     *
     * @param arr    待查找数组
     * @param target 待查找目标值
     * @return 如果找到，返回目标值最靠左的索引，如果没找到，返回比目标值大的最靠左的值
     */
    public static int binarySearchLeftMost2(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= arr[m]) {
                j = m - 1;
            } else if (arr[m] < target) {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * 二分查找RightMost2
     *
     * @param arr    待查找数组
     * @param target 待查找目标值
     * @return 如果找到，返回目标值最靠右的索引
     * 如果没找到，返回比目标值小的最靠右的值
     */
    public static int binarySearchRightMost2(int[] arr, int target) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < arr[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }


    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 8, 9};
        int target = 4;
        int i = Arrays.binarySearch(a, target);
        System.out.println(i);
        if (i < 0) {
            int insertIndex = Math.abs(i + 1);
            int[] b = new int[a.length + 1];
            System.arraycopy(a, 0, b, 0, insertIndex);
            b[insertIndex] = target;
            System.arraycopy(a, insertIndex, b, insertIndex + 1, a.length - insertIndex);
            System.out.println(Arrays.toString(b));
        }
    }
}
