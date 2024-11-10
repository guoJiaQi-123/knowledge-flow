package com.tyut.map;

import java.util.HashMap;

public class MainHashMap {
    public static void main(String[] args) {
        //创建一个HashMap实例，存储String类型的键值对
        HashMap<String, Integer> hashMap = new HashMap<>(); // 复杂度: 0(1)

        //向HashMap添加键值对
        hashMap.put("One", 1);// 复杂度:0(1)
        hashMap.put("Two", 2);// 复杂度：0(1)
        hashMap.put("Three", 3);// 复杂度:0(1)
        hashMap.put(null, 4); // hashmap允许一条key为 null，多条value为null

        //获取HashMap的大小
        int size = hashMap.size();// 复杂度：0(1)
        System.out.println("Size of HashMap:：" + size);

        //检查HashMap是否包含特定键
        boolean containsKey = hashMap.containsKey("Two"); // 复杂度: 0(1)
        System.out.println("HashMap contains key 'Two':" + containsKey);

        //获取特定键对应的值
        int value = hashMap.get("One");// 复杂度：0(1)
        System.out.println("'One' maps to value: " + value);
        Integer value2 = hashMap.get(null);
        System.out.println("hashmap允许一条key为 null：" + value2);

        //删除特定键值对
        int removedValue = hashMap.remove("Two");// 复杂度：0(1)
        System.out.println("Removed value associated with 'Two':" + removedValue);

        //打印HashMap中的键值对
        System.out.println("HashMap entries: " + hashMap);

        //清空HashMap
        hashMap.clear();// 复杂度：0(n)
        System.out.println("HashMap after clearing:" + hashMap);
    }
}