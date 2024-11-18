package com.dataStructure.dataStructure.hashtable;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 */
public class E06Leetcode242 {

    /**
     * 方法一：
     * 转换为字符数组排序后比较字符数组
     */
    public boolean isAnagram(String s, String t) {
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        String s1 = new String(sCharArray);
        String s2 = new String(tCharArray);
        return s1.equals(s2);
    }


    /**
     * 方法二：
     * 字符打散放入int[26]数组，数组中记录字母出现的次数，最后比较数组
     */
    public boolean isAnagram2(String s, String t) {
        return Arrays.equals(keyArray(s), keyArray(t));
    }

    private int[] keyArray(String s) {
        int[] ints = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            ints[c - 97]++;
        }
        return ints;
    }


}
