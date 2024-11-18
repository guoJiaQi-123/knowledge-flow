package com.dataStructure.algorithm.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 组合之和 2
 */
public class CombinationLeetcode40 {
    /*
    输入: candidates = [10,1,2,7,6,1,5], target = 8,
    输出:
            [
            [1,1,6],
            [1,2,5],
            [1,7],
            [2,6]
            ]
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        dfs(0, candidates, target, new boolean[candidates.length], new LinkedList<>(), result);
        return result;
    }

    public void dfs(int start, int[] candidates, int target, boolean[] visited, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(stack));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (target < candidate) {
                continue; // 减枝
            }
            // 如果相邻的两个值相等，且前一个值还没有被访问，则跳过循环
            // （相邻的值只有一个可以被先访问，防止组合结果出现重复）比如：【521，512】
            if (i > 0 && candidate == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            stack.push(candidate);
            // 不同点，从当前遍历到的元素后面开始递归，start = i+1;排除自身（使得结果中一个元素只能出现一次）
            dfs(i + 1, candidates, target - candidate, visited, stack, result);
            stack.pop();
            visited[i] = false;
        }
    }

}
