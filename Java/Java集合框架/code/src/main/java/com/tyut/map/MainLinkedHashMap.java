package com.tyut.map;

import java.util.LinkedHashMap;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote LinkedHashMap使用实例
 */
public class MainLinkedHashMap {
    /*
        LinkedHashMap是HashMap的子类
     */
    public static void main(String[] args) {
        //创建一个LinkedHashMap实例，存储String类型的键值对
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(); // 复杂度: 0(1)

        //向LinkedHashMap添加键值对
        linkedHashMap.put("One", 1);// 复杂度:0(1)
        linkedHashMap.put("Two", 2);// 复杂度：0(1)
        linkedHashMap.put("Three", 3);// 复杂度:0(1)

        //获取LinkedHashMap的大小
        int size = linkedHashMap.size(); // 复杂度: 0(1)
        System.out.println("Size of LinkedHashMap:：" + size);

        //检查LinkedHashMap是否包含特定键
        boolean containsKey = linkedHashMap.containsKey("Two"); // 复杂度: 0(1)
        System.out.println("LinkedHashMap contains key 'TWo':" + containsKey);

        // 获取特定键对应的值
        int value = linkedHashMap.get("One");// 复杂度: 0(1)
        System.out.println("'one' maps to value: " + value);

        //删除特定键值对
        int removedValue = linkedHashMap.remove("Two");// 复杂度：0(1)
        System.out.println("Removed value associated with 'Two': " + removedValue);

        //打印LinkedHashMap中的键值对
        System.out.println("LinkedHashMap entries: " + linkedHashMap);

        //清空LinkedHashMap
        linkedHashMap.clear();//复杂度：0(n)
        System.out.println("LinkedHashMap after clearing: " + linkedHashMap);
    }
}
