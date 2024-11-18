package com.dataStructure.algorithm.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/02/29
 * @version v1.0
 * @apiNote 组合总和 3
 */
public class CombinationLeetcode216 {

    /*
            输入: k = 3, n = 7
            输出: [[1,2,4]]
     */

    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> result = new LinkedList<>();
        dfs(1, k, target, new LinkedList<>(), result);
        return result;
    }

    public void dfs(int start, int k, int target, LinkedList<Integer> stack, List<List<Integer>> result) {
        if (target == 0 && stack.size() == k) {
            result.add(new LinkedList<>(stack));
            return;
        }
        for (int i = start; i <= 9; i++) {

            if (stack.size() == k) {
                continue; // 剪枝
            }
            if (target < i) {
                continue; // 剪枝
            }
            stack.push(i);
            dfs(i + 1, k, target - i, stack, result);
            stack.pop();
        }

    }
}
