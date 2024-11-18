package com.dataStructure.dataStructure.hashtable;

import java.util.*;

public class E08Leetcode819 {
    /**
     * 1.将 paragraph 截取为一个个单词
     * 2.将单词加入 map 集合，单词本身作为 key，单词的出现次数作为 value，避免禁用词加入
     * 3.在 map 集合中找到 value 最大的，返回他对应的key即可
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        // 1.将paragraph截取为一个个单词
        String[] strings = paragraph.toLowerCase().split("[^A-Za-z]");
        HashMap<String, Integer> map = new HashMap<>();
        // 2.将单词加入 map 集合，单词本身作为 key，单词的出现次数作为 value，避免禁用词加入
        for (String key : strings) {
            if (!set.contains(key)) {//当key不在set集合，意味着key不是禁用词
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        // 3.在 map 集合中找到 value 最大的，返回他对应的key即可
        Optional<Map.Entry<String, Integer>> optional = map.entrySet().stream().max(Map.Entry.comparingByValue());
        return optional.map(Map.Entry::getKey).orElse(null);
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet<>();
        for (String s : banned) {
            banSet.add(s);
        }
//        Set<String> banSet = Set.of(banned);
        HashMap<String, Integer> map = new HashMap<>();
        char[] charArray = paragraph.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        // 1.将paragraph剪切为一个一个单词
        for (char ch : charArray) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else {
                put(sb, banSet, map);
                sb = new StringBuilder();
            }
        }
        //防止只有一个单词的情况，没有非字母进行字符串分割
        put(sb, banSet, map);

        Integer max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }

    private static void put(StringBuilder sb, Set<String> banSet, HashMap<String, Integer> map) {
        if (sb.length() > 0) {
            String key = sb.toString();
            // 2.将单词加入到map集合中
            if (!banSet.contains(key)) {
                map.compute(key, (k, v) -> v == null ? 1 : v + 1);
            }
        }
    }
}
