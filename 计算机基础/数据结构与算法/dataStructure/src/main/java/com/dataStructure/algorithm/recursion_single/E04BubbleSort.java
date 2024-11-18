package com.dataStructure.algorithm.recursion_single;

/**
 * 递归法实现冒泡排序
 */
public class E04BubbleSort {
    public static void sort(int[] arr){
        bubble(arr,arr.length-1);
    }

    /**
     * 递归法实现冒泡排序
     * @param arr 待排序数组
     * @param j 未排序范围边界
     */
    private static void bubble(int[] arr,int j){
        if(j==0){
            return;
        }
        int x = 0;
        for(int i=0;i<j;i++){
            if(arr[i]>arr[i+1]){
                int t = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = t;
                x = i;       //如果发生了排序，则将最后一次排序的i值赋给x，x就是已排序和未排序的分界线，在x右侧的均为排序完成的
            }
        }
        bubble(arr,x);
    }
}
