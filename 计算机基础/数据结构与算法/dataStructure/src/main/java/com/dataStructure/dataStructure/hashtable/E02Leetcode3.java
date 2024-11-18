package com.dataStructure.dataStructure.hashtable;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 * <p>1. 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。</p>
 * <p>2. s 由英文字母、数字、符号和空格组成</p>
 */
public class E02Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        /*
                [(a,3) (b,1) (c,2)]

                b
                    e
                abcabcbb


                要点：
                1.用 begin 和 end 表示子串开始和结束位置
                2.用 hash 表检查重复字符
                3.从左向右查看每个字符, 如果:
                 - 没遇到重复字符，调整 end
                 - 遇到重复的字符，调整 begin
                 - 将当前字符放入 hash 表
                4.end - begin + 1 是当前子串长度
        */
        //使用map检查是否有重复字符，其中key-字符 value-字符下标
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        //定义maxLength变量记录最长子串
        int maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            //遍历字符串，获取每一个字符
            char ch = s.charAt(end);
            //如果当前字符存在map中，说明重复了
            if (map.containsKey(ch)) { //重复
                //将begin修改为在begin和end范围内，重复字符的下一个字符索引
                begin = Math.max(begin, map.get(ch) + 1);
                //将重复字符的下标修改
                map.put(ch, end);
            } else { //不重复
                //将字符和字符下标放入map集合中
                map.put(ch, end);
            }
            //最大长度即为每次循环得到的字符串的最大值
            maxLength = Math.max(maxLength, end - begin + 1);
        }
        //返回无重复最大子串长度
        return maxLength;
    }


}
