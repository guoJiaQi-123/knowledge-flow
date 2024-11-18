package com.dataStructure.dataStructure.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 */
@SuppressWarnings("all")
public class E03Leetcode49 {
    //方法一：
    //思路：将字符串数组中的每个字符串都进行重新排序，字母异位词排序后相同
    //将排序后相同的全部放入map哈希表中即可
    public List<List<String>> groupAnagrams1(String[] strs) {
        //定义一个哈希表 key——排序后的字符串  value——原字符串
        HashMap<String, List<String>> map = new HashMap<>();
        //遍历字符串数组
        for (String str : strs) {
            //获取每个字符串的字符数组
            char[] charArray = str.toCharArray();
            //对字符数组重新排序，如果是异位词，则重新排序后的字符串是一样的
            Arrays.sort(charArray);
            //将排序后的字符数组再转换为字符串
            String key = new String(charArray);
            //在哈希表中查找key为‘key’的列。
            List<String> list = map.get(key);
            //如果没有，则创建一个新的list并且以key的value放入map中
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            //如果有，则直接将原始字符串（未排序）添加到list中
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }


    //方法二： <性能更优>
    //思路：因为题中提出字符串中所有字符均为小写字母，因此最多只有26种情况
    //只需为每个字符串建立一个长度为26的字符数组，将出现的每个字符都将其对应的数组下标的值加1
    //最后如果是字母异位词，他们的字符数组都是相同的，加入到map集合即可
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<arrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //为每个字符串建立其对应的字符数组
            arrayKey key = new arrayKey(str);
            //如果key存在，则返回key对应的value，如果不存在，则创建一个key并建立一个新的list作为其value
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    static class arrayKey {
        int[] array = new int[26];

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            arrayKey arrayKey = (arrayKey) o;
            return Arrays.equals(array, arrayKey.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }

        //将字符串的每个字符对应的数组下标的值加1
        public arrayKey(String str) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                array[c - 97]++;
            }
        }
    }
}
