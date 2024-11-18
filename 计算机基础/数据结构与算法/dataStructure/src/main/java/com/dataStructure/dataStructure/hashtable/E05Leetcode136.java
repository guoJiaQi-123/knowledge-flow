package com.dataStructure.dataStructure.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class E05Leetcode136 {
    public int singleNumber(int[] nums) {
        //key - num   value - 出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 2);
            } else {
                map.put(num, 1);
            }

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.get(entry.getKey()) == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 优化版
     * 思路：因为题中说重复元素出现的次数一定为 2 ，我们可以利用这个信息，
     * 当元素第一次出现，添加到set集合，当元素第二次出现，将元素从set集合中删除
     * 这样，重复元素最终都会被从set集合中删除，而最终剩余一个不重复元素
     */
    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) { //如果添加不成功，说明当前元素第二次出现，将之前添加的该元素删除
                set.remove(num);
            }
        }
        return set.toArray(new Integer[0])[0];
    }

    /**
     * 思路2：使用位运算（异或）
     * 异或运算是位运算中的一种重要运算符，用符号 "^" 表示。它逐位比较两个数的对应位，
     * 如果对应位不相同，则结果为 1；如果对应位相同，则结果为 0。以下是一些异或运算的特性：
     */
    public int singleNumber3(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //两个相同的数做异或运算结果为0
            //0和任意一个数做异或运算结果都是原来的数
            //通过这种特性，将nums数组中的所有值都做异或运算，重复值将归0
            //不重复值^0任然不变，最后返回的即为唯一一个不重复的值
            num = num ^ nums[i];
        }
        return num;
    }
}
