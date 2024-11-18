package com.dataStructure.algorithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author OldGj 2024/03/09
 * @version v1.0
 * @apiNote 78. 子集
 */
public class SubsetLeetcode78 {

    /*
            nums = [1,2,3]
            [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     */

    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    // 主函数
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法核心函数，遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {

        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetLeetcode78 subsetLeetcode78 = new SubsetLeetcode78();
        List<List<Integer>> subsets = subsetLeetcode78.subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }

}
