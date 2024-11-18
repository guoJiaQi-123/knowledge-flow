package com.dataStructure.algorithm.string;

/**
 * @author OldGj 2024/03/03
 * @version v1.0
 * @apiNote 5.最长回文子串
 */
public class LongestPalindromeLeetcode5 {
    public String longestPalindrome(String s) {
        /*
                b   a   b   a   d

         */
        left = 0;
        right = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length - 1; i++) {
            extend(charArray, i, i); // 奇数回文子串
            extend(charArray, i, i + 1); // 偶数回文子串
        }
        return new String(charArray, left, right - left + 1);
    }

    static int left;
    static int right;

    /**
     * 中心扩展
     */
    public static void extend(char[] chars, int i, int j) {
        // 如果指针i,j指向的字符相等，则指针向外扩展，判断后序字符是否相等
        while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
            i--;
            j++;
        }
        // 循环结束，将i++,j--,回到最后一次相等的字符索引处
        i++;
        j--;
        // 如果本次循环得到的回文子串长度大于之前记录的长度，则更新原来的记录
        if ((j - i) > (right - left)) {
            left = i;
            right = j;
        }
    }
}
