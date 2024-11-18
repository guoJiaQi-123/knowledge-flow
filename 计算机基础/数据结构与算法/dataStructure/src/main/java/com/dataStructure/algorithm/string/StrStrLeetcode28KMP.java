package com.dataStructure.algorithm.string;

import java.util.Arrays;

/**
 * @author OldGj 2024/03/03
 * @version v1.0
 * @apiNote 字符串匹配算法 - KMP
 */
public class StrStrLeetcode28KMP {
    public static int strStr(String haystack, String needle) {


        /*                    j
                " l e t l e t o "         -> pattern
                " l e t l e t c o d e "   -> origin
                              i
         */
        // 根据模式字符串得到前后缀数组
        int[] lps = lps(needle);
        char[] origin = haystack.toCharArray();
        char[] pattern = needle.toCharArray();
        int i = 0;
        int j = 0;
        // 如果原始字符串剩余的长度 >= 模式字符串剩余的长度，则循环
        while ((origin.length - i) >= (pattern.length - j)) {
            if (origin[i] == pattern[j]) { // 匹配成功
                i++;
                j++;
            } else if (j == 0) { // 匹配不成功，并且j==0
                i++;
            } else {
                j = lps[j - 1];  // j 根据最长公共前缀表中的值，向回找
                // lps[j - 1]表示模式字符串中前j个字符组成的字符串的最长公共前缀
            }
            if (j == pattern.length) {
                return i - j;
            }
        }
        return -1;
    }

    /**
     * 根据模式字符串求解最长前后缀数组
     * 1.索引：使用了模式串前j个数组 - 1
     * 2.值：最长前后缀的长度
     * @param patterns 模式字符串
     * @return 最长前后缀数组
     */
    public static int[] lps(String patterns) {
        int[] lps = new int[patterns.length()];
        char[] pattern = patterns.toCharArray();
        /*
                 [ 0,1,2,0,1,2,3,3,3,4 ] lps 数组

                                     j
                "              a a a c a a a a a c "   前缀
                "  a a a c a a a a a c "     后缀
                                     i

                  遇到相同字符：
                        记录共同前后缀长度
                        长度即为 j + 1
                        长度记录至数组 i 索引处
                        然后 i++ j++

                  遇到不同字符
                        前面没有共同部分(j == 0)
                            i++
                        前面有共同部分,j向回找
                            无需对比的地方，可以跳过
                            无需对比的字符个数，之前已计算过
         */
        int i = 1; // 后缀
        int j = 0; // 前缀 同时也是数量
        while (i < pattern.length) {
            if (pattern[i] == pattern[j]) { // 相同字符
                lps[i] = j + 1; // 记录共同前后缀长度
                j++;
                i++;
            } else if (j == 0) { // j 前面没有公共前缀
                i++;
            } else {
                j = lps[j - 1]; // j 向回找
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        int[] lps = lps("letleto"); // 0001230
        System.out.println(Arrays.toString(lps));
    }
}
