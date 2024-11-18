package com.dataStructure.dataStructure.hashtable;

import java.util.HashMap;

/**
 * 两数之和
 */
public class E01leetcode1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int k = target - nums[i];
            if (map.containsKey(k)) {
                return new int[]{i, map.get(k)};
            } else {
                map.put(num, i);
            }
        }
        return null;
    }
}
