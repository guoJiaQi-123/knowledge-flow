package com.tyut.map;

import java.util.Hashtable;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote HashTable使用示意
 */
public class MainHashTable {

    /*
        Hashtable 的 key 和 value 都不允许为 null
     */
    public static void main(String[] args) {
        //创建一个HashTable实例，存储String类型的键值对
        Hashtable<String, Integer> hashtable = new Hashtable<>();// 复杂度: 0(1)

        //向HashTable添加键值对
        hashtable.put("One", 1);// 复杂度:0(1)
        hashtable.put("Two", 2);// 复杂度:0(1)
        hashtable.put("Three", 3);// 复杂度:0(1)

        //获取HashTable的大小
        int size = hashtable.size();// 复杂度:0(1)
        System.out.println("Size of Hashtable: " + size);

        //检查HashTable是否包含特定键
        boolean containsKey = hashtable.containsKey("Two");// 复杂度：0(1)
        System.out.println("Hashtable contains key 'Two': " + containsKey);

        // 获取特定键对应的值
        int value = hashtable.get("One");// 复杂度:0(1)
        System.out.println("'one' maps to value: " + value);

        //删除特定键值对
        int removedValue = hashtable.remove("Two"); // 复杂度: 0(1)
        System.out.println("Removed value associated with Two':" + removedValue);

        //打印HashTable中的键值对
        System.out.println("Hashtable entries: " + hashtable);

        //清空HashTable
        hashtable.clear();// 复杂度:0(n)
        System.out.println("Hashtable after clearing: " + hashtable);
    }
}
