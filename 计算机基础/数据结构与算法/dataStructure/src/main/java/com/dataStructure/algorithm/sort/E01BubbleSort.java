package com.dataStructure.algorithm.sort;


/**
 * 冒泡排序
 */
public class E01BubbleSort {
    /**
     * 非递归实现
     */
    public static void bubbleSort(int[] a) {
        // 初始化未排序区域的右边界为数组中最后一个元素
        int j = a.length - 1;
        do {
            //定义一个变量 x 记录未排序区域的右边界
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    // 每次交换后，更新变量x,最后一次交换后x的值为经过一轮排序后新的右边界，优化代码
                    x = i;
                }
            }
            //将x的值赋值给未排序区域的右边界
            j = x;
        } while (j != 0);//只要未排序区域右边界不为零，则循环
    }

    /**
     * 递归实现
     * @param a 待排序数组
     * @param j 未排序区域的右边界
     */
    public static void bubbleSort(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                x = i;
            }
        }
        bubbleSort(a, x);
    }
}
