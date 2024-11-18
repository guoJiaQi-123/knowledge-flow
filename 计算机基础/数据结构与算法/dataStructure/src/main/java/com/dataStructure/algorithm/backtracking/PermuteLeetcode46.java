package com.dataStructure.algorithm.backtracking;

import java.util.*;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 全排列 LeetCode 46
 */
public class PermuteLeetcode46 {

    public List<List<Integer>> permute(int[] nums) {
        // 定义一个集合存放结果
        List<List<Integer>> result = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] booleans = new boolean[nums.length];
        backTrack(nums, booleans, new LinkedList<>(), result);// 回溯算法
        return result;
    }

    /**
     * 全排列
     *
     * @param nums     需要全排列的数组
     * @param booleans 是否访问的boolean数组
     * @param track    自定义栈实现回溯
     * @param result   结果集合
     */
    private void backTrack(int[] nums, boolean[] booleans,
                           LinkedList<Integer> track, List<List<Integer>> result) {
        // 递归的结束条件，当自定义栈中的数据个数和原始数组中的相同是，将其加入结果集合
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            // 只有在元素没有被访问的情况下才做选择
            if (!booleans[i]) {
                track.push(nums[i]);
                booleans[i] = true;
                // 进入下一层决策树
                backTrack(nums, booleans, track, result); // 递归
                track.pop(); // 回溯
                booleans[i] = false;  // 回溯
            }
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        doPermute2(nums, 0, nums.length - 1, result);
        return result;
    }

    private static void doPermute2(int[] nums, int start, int end, List<List<Integer>> result) {
        if (end == start) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
        }
        for (int i = start; i <= end; i++) {
            swap(nums, start, i); // 每一个值都要换到第一位
            doPermute2(nums, start + 1, end, result); // 递归 固定前面的，将后面的值进行全排列
            swap(nums, start, i); //回溯
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
