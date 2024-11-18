package com.dataStructure.algorithm.recursion_single;

/**
 * 递归实现二分查找
 */
public class E03BinarySearch {

    public int search(int[] arr,int target){
        return f(arr,target,0,arr.length-1);
    }

    /**
     * 递归法实现二分查找
     * @param arr 待查找数组
     * @param target 待查找目标值
     * @param i 查找左范围
     * @param j 查找右范围
     * @return 如果找到，返回目标元素的索引，如果没找到，返回-1
     */
    private static int f(int[] arr,int target,int i,int j){
        if(i>j){
            return -1;
        }

        int m =(i+j)>>>1;
        if(target<arr[m]){
            return f(arr,target,i,m-1);
        }else if(arr[m]<target){
            return f(arr,target,m+1,j);
        }else {
            return m;
        }
    }
}
