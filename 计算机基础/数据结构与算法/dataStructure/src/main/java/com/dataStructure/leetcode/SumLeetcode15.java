package com.dataStructure.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 15. 三数之和
 */
public class SumLeetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
            输入：nums = [-1,0,1,2,-1,-4]
            输出：[[-1,-1,2],[-1,0,1]]
            -4  -1  -1  0   1   2

         */
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        dfs(3, 0, nums.length - 1, nums, 0, new LinkedList<>(), result);
        return result;
    }

    public void dfs(int n, int i, int j, int[] nums, int target,
                    LinkedList<Integer> stack, List<List<Integer>> result) {
        if (n == 2) {
            // 求解两数之和
            towSum(nums, i, j, target, stack, result);
            return;
        }
        for (int k = i; k < j - (n - 2); k++) {
            if (k > i && nums[k] == nums[k - 1]) {
                continue;
            }
            int num = nums[k];
            stack.push(num); // 固定一个值
            dfs(n - 1, k + 1, j, nums, target - num, stack, result);
            stack.pop();
        }

    }

    private void towSum(int[] nums, int i, int j, int target,
                        LinkedList<Integer> stack, List<List<Integer>> result) {

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                ArrayList<Integer> list = new ArrayList<>(stack);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
    }
}
