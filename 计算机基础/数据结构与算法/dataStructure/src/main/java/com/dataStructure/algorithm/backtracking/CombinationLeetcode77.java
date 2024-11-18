package com.dataStructure.algorithm.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 组合 LeetCode 77
 */
public class CombinationLeetcode77 {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {

        dfs(1, n, k);
        return result;
    }

    private void dfs(int start, int n, int k) {
        if (stack.size() == k) {
            result.add(new LinkedList<>(stack));
            return;
        }
        for (int i = start; i <= n; i++) {
            // k - stack.size() -> 还差多少
            // n - i + 1  -> 剩余多少
            // 如果剩余的比需要的还少，则不需要递归
            if (k - stack.size() > n - i + 1) { // 减枝
                continue;
            }
            stack.push(i);
            dfs(i + 1, n, k); // 递归
            stack.pop(); // 回溯
        }
    }
}
