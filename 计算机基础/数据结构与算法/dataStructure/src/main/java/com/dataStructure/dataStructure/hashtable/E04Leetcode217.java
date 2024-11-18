package com.dataStructure.dataStructure.hashtable;


import java.util.HashMap;
import java.util.HashSet;

/**
 * 217. 存在重复元素
 */
public class E04Leetcode217 {
    public boolean containsDuplicate(int[] nums) {
        // key - num  value - 次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }

    /**
     * 优化版
     */
    public boolean containsDuplicate1(int[] nums) {
        //初始化容量大一点可以避免map扩容造成不必要的耗时
        HashMap<Integer, Object> map = new HashMap<>(nums.length * 2);
        Object value = new Object();
        for (int num : nums) {
            Object i = map.put(num, value);
            if (i != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * hashset版
     */
    public boolean containsDuplicate2(int[] nums) {
        HashSet<Object> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
