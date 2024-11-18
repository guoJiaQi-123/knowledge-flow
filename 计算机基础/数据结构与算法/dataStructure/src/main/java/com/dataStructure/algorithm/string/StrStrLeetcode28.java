package com.dataStructure.algorithm.string;

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
            // j 从零开始遍历模式字符串
            for (j = 0; j < pattern.length; j++) {
                // 如果发现模式字符串中有字符与原始字符串不匹配，则跳出循环
                if (pattern[j] != origin[i + j]) {
                    break;
                }
            }
            // 如果是正常走完了所有for循环，说明发现了模式字符串与原始字符串完全匹配，返回i索引
            if (j == pattern.length) {
                return i;
            }
            // 如果是跳出循环的，i++，匹配后面的字符
            i++;
        }
        return -1;
    }
}
