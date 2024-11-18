package com.dataStructure.algorithm.divideandconquer;

/**
 * @author OldGj 2024/02/28
 * @version v1.0
 * @apiNote 395. 至少有 K 个重复字符的最长子串
 */
public class LongestSubstringLeetcode395 {
    /*
        统计字符串中每个字符的出现次数，移除哪些出现次数 < k 的字符
            剩余的子串，递归做此处理，直至
                 - 整个子串长度 < k (排除)
                 - 子串中没有出现次数 < k 的字符
     */

    public int longestSubstring(String s, int k) {
        // 如果子串的所有长度都小于K，则直接落选
        if (s.length() < k) {
            return 0;
        }
        /*
                    s = "aaaabbbcccc", k = 4
                         aaaa   cccc   -> 递归
                          4      4     -> 返回 4

                    s = " dddxaabaaabaaziiiiyfbff"   k = 3
                          ddd aabaaabaa iiii fbff    -> 递归
                          ddd aa aaa aa iiii f ff    -> 递归
                          3   ×   3  ×   4   ×  ×    ->  返回 4
         */
        // 定义一个长26的数组，记录每个字母出现的次数
        int[] counts = new int[26];
        char[] charArray = s.toCharArray();
        // 记录每个字符出现的次数
        for (char c : charArray) {
            // 遍历每个字母，给对应的数组中的索引处+1，映射关系 a -> 0 ;  b -> 1 ...
            counts[c - 'a']++;
        }
        // 遍历每个字符
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            // 取到该字符出现的次数
            int count = counts[c - 'a'];
            // 如果该字符出现次数少于k，则需要被截取
            if (count > 0 && count < k) {
                // 定义指针j为i+1,如果从第一个需要被截取的字符（索引为i）开始，后面仍然有出现次数少于K的字符，则将j++
                int j = i + 1;
                while (j < s.length() && counts[charArray[j] - 'a'] < k) {
                    j++;
                }
                // 递归调用，计算被截取的两端字符串的有 K 个重复字符的最长子串
                return Integer.max(
                        longestSubstring(s.substring(0, i), k),
                        longestSubstring(s.substring(j), k));
            }
        }
        // 如果子串的所有字符出现的次数都大于k，则直接返回子串长度
        return s.length();
    }
}
