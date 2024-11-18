package com.dataStructure.algorithm.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 组合总和 LeetCode 39
 */
public class CombinationLeetcode39 {

    /*
            输入：candidates = [2,3,6,7], target = 7
            输出：[[2,2,3],[7]]

     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(0, candidates, target, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int start, int[] candidates, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                continue;
            }
            stack.push(candidate); // 固定一个，后面的继续递归
            dfs(i, candidates, target - candidate, stack, result); // 递归
            stack.pop(); // 回溯
        }
    }
}
