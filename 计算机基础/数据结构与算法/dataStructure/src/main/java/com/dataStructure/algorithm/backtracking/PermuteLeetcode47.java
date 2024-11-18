package com.dataStructure.algorithm.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 无重复 全排列
 */
public class PermuteLeetcode47 {
    public List<List<Integer>> permute(int[] nums) {
        // 定义一个集合存放结果
        List<List<Integer>> result = new LinkedList<>();
        /******************************和46的区别*******************************/
        Arrays.sort(nums); // 排序
        /******************************和46的区别*******************************/
        doPermute(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    private void doPermute(int[] nums, boolean[] booleans, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new LinkedList<>(stack));
        }
        for (int i = 0; i < nums.length; i++) {
            /******************************和46的区别*******************************/
            if (i > 0 && nums[i] == nums[i - 1] && !booleans[i - 1]) {
                continue; // 相邻元素如果相等且前一个元素还没有被处理，则跳过 【两个相邻元素只有一个可以先被处理，排除重复】
            }
            /******************************和46的区别*******************************/
            if (!booleans[i]) {
                stack.push(nums[i]);
                booleans[i] = true;
                doPermute(nums, booleans, stack, result); // 递归
                stack.pop(); // 回溯
                booleans[i] = false;  // 回溯
            }
        }
    }
}
