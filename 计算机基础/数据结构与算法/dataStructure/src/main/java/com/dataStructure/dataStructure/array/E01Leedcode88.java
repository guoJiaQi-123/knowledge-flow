package com.dataStructure.dataStructure.array;

import java.util.Arrays;

public class E01Leedcode88 {

    //方法一：迭代 双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int i = 0, j = 0, k = 0;
        //当i和j都小于m和n时，循环
        while (i < m && j < n) {
            //当nums1[i]小于nums2[j]时，将nums1[i]放入nums3[k]
            if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i];
                k++;
                i++;
                //当nums1[i]大于等于nums2[j]时，将nums2[j]放入nums3[k]
            } else {
                nums3[k] = nums2[j];
                k++;
                j++;
            }
        }
        //当i小于m时，将nums1[i]放入nums3[k]
        while (i < m) {
            nums3[k] = nums1[i];
            k++;
            i++;
        }
        //当j小于n时，将nums2[j]放入nums3[k]
        while (j < n) {
            nums3[k] = nums2[j];
            k++;
            j++;
        }
        //将nums3复制到nums1
        System.arraycopy(nums3, 0, nums1, 0, m + n);
    }

    //方法二：递归
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        //将nums2中的元素复制到nums1中
        System.arraycopy(nums2, 0, nums1, m, n);
        //创建一个新的数组
        int[] nums3 = new int[m + n];
        //调用merge方法，将nums1和nums3合并
        merge(nums1, 0, m - 1, m, m + n - 1, nums3, 0);
        //将合并后的结果复制到nums1中
        System.arraycopy(nums3, 0, nums1, 0, n + m);
    }

    private static void merge(int[] arr, int i, int iEnd, int j, int jEnd, int[] arr2, int k) {
        //如果i大于iEnd，则将arr中的元素复制到arr2中
        if (i > iEnd) {
            System.arraycopy(arr, j, arr2, k, jEnd - j + 1);
            return;
        }
        //如果j大于jEnd，则将arr中的元素复制到arr2中
        if (j > jEnd) {
            System.arraycopy(arr, i, arr2, k, iEnd - i + 1);
            return;
        }

        //如果arr[i]小于arr[j]，则将arr[i]复制到arr2中
        if (arr[i] < arr[j]) {
            arr2[k] = arr[i];
            //递归调用merge方法，将arr[i+1]和arr[j]合并
            merge(arr, i + 1, iEnd, j, jEnd, arr2, k + 1);
        } else {
            //将arr[j]复制到arr2中
            arr2[k] = arr[j];
            //递归调用merge方法，将arr[i]和arr[j+1]合并
            merge(arr, i, iEnd, j + 1, jEnd, arr2, k + 1);
        }
    }

    //迭代：逆向双指针
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        //当i和j都大于等于0时，比较nums1[i]和nums2[j]，将较大的值放入nums1[k]
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        //当i小于0时，将nums2中的值放入nums1
        while (i >= 0) {
            nums1[k] = nums1[i];
            k--;
            i--;
        }
        //当j小于0时，将nums1中的值放入nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }

    public static void merge4(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        int[] newArr = new int[m + n];
        merge9(nums1, 0, m - 1, m, m + n - 1, newArr, 0);
        System.arraycopy(newArr, 0, nums1, 0, m + n);
    }

    private static void merge9(int[] num, int i, int iEnd, int j, int jEnd, int[] newArr, int k) {
        if (i > iEnd) {
            System.arraycopy(num, j, newArr, k, jEnd - j + 1);
            return;
        }
        if (j > jEnd) {
            System.arraycopy(num, i, newArr, k, iEnd - i + 1);
            return;
        }

        if (num[i] < num[j]) {
            newArr[k] = num[i];
            merge9(num, i + 1, iEnd, j, jEnd, newArr, k + 1);
        } else {
            newArr[k] = num[j];
            merge9(num, i, iEnd, j + 1, jEnd, newArr, k + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {2, 5, 6};
        E01Leedcode88.merge4(arr1, 3, arr2, 3);
        System.out.println(Arrays.toString(arr1));
    }
}
