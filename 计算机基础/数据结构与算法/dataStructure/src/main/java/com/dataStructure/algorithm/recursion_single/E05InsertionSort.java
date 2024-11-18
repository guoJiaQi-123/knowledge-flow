package com.dataStructure.algorithm.recursion_single;

public class E05InsertionSort {

    public static void sort(int[] arr){
        insertion2(arr,1);
    }

    /**
     * 递归实现插入排序
     * @param arr 待排序数组
     * @param low 未排序部分的左边界
     */
    private static void insertion(int[] arr,int low) {
        if (low == arr.length) {
            return;
        }

        int t = arr[low];
        int index = low - 1;//已排序部分指针
        while (index >= 0 && arr[index] > t) {//为找到插入位置
            arr[index + 1] = arr[index];
            index--;
        }
        if (index + 1 != low) {
            arr[index + 1] = t;//找到插入位置
        }
        insertion(arr,low+1);

    }

    /**
     * 第二种方式实现插入排序
     */
    private static void insertion2(int[] arr,int low){
        if(low == arr.length){
            return;
        }

        int index = low-1; //已排序部分的指针
        while (index >= 0 && arr[index] > arr[index+1]){
            int t = arr[index];
            arr[index] = arr[index+1];
            arr[index+1] = t;
            index--;
        }

        insertion2(arr,low+1);
    }
}
