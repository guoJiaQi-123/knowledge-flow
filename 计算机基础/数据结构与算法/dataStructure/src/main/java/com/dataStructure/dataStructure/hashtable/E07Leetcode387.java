package com.dataStructure.dataStructure.hashtable;

import java.util.HashMap;

/**
 * 387.字符串中的第一个唯一字符
 */
public class E07Leetcode387 {

    /**
     * 方法一：使用hashmap存放数据
     * key - 字符   value - 出现次数
     */
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, 2);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer i1 = map.get(c);
            if (i1 == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法二：将字符打散加入到int[26]长度为26的int数组中
     */
    public int firstUniqChar2(String s) {
        int[] ints = keyArray(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int anInt = ints[c - 97];
            if (anInt == 1) {
                return i;
            }
        }
        return -1;
    }

    private int[] keyArray(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c - 97]++;
        }
        return array;
    }
}
