package com.dataStructure.algorithm.string;

/**
 * @author OldGj 2024/03/03
 * @version v1.0
 * @apiNote 14.最长公共前缀
 */
public class LCPLeetcode14 {

    // 纵向扫描
    public String longestCommonPrefix(String[] strs) {
        /*
                f   l   o   w   e   r
                f   l   o   w
                f   l   i   g   h   t
         */
        // 获取第一个字符串
        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            // 获取第一个字符串中的每一个字符
            char ch = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // 获取其他字符串
                String str = strs[j];
                // 如果字符串数组中第j个字符串的长度小于i
                // 或者字符串数组中第j个字符串的第i个字符与第一个字符串的第i个字符不相等
                // 则返回第一个字符串的前i个字符
                if (str.length() == i || ch != str.charAt(i)) {
                    return new String(first.toCharArray(), 0, i);
                    // return first.substring(0,i);
                }
            }
        }
        // 如果遍历完字符串数组中第一个字符串的所有字符，没有出现上面的情况，则返回第一个字符串
        return first;
    }
}
