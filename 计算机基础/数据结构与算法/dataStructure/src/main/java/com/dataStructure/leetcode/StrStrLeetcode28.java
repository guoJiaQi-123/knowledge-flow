package com.dataStructure.leetcode;

/**
 * @author OldGj 2024/03/03
 * @version v1.0
 * @apiNote 28. 找出字符串中第一个匹配项的下标 - 暴力匹配
 */
public class StrStrLeetcode28 {
    public int strStr(String haystack, String needle) {
        char[] origin = haystack.toCharArray(); // 原始字符串
        char[] pattern = needle.toCharArray(); // 模式字符串
        /*             j
                      "l e e t o"         -> pattern
                "l e e t c o d e"   -> origin
                       i
         */
        int i = 0;
        int j = 0;
        while (i <= origin.length - pattern.length) {
            for (j = 0; j < pattern.length; j++) {
                if (pattern[j] != origin[i + j]) {
                    break;
                }
            }
            if (j == pattern.length) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
