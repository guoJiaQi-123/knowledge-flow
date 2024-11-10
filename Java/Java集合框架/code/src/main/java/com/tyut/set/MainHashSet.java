package com.tyut.set;

import java.util.HashSet;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote HashSet方法示例
 */
public class MainHashSet {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //创建一个HashSet实例，存储string类型的元素
        HashSet<String> hashSet = new HashSet<>(); // 复杂度: O(1)

        //向HashSet添加元素
        hashSet.add("Apple");// 复杂度:0(1)
        hashSet.add("Banana"); // 复杂度:0(1)
        hashSet.add("cherry"); // 复杂度:0(1)

        //打印HashSet中的元素
        System.out.println("HashSet:" + hashSet);

        //获取HashSet的大小
        int size = hashSet.size();// 复杂度：0(1)
        System.out.println("Size of Hashset: " + size);

        //检查HashSet是否为空
        boolean isEmpty = hashSet.isEmpty(); // 复杂度: 0(1)
        System.out.println("Is HashSet empty::" + isEmpty);

        //检查HashSet中是否包含某个元素
        boolean contains = hashSet.contains("Banana");// 复杂度:0(1)
        System.out.println("HashSet contains'Banana': " + contains);

        //删除HashSet中的元素
        hashSet.remove("Apple");// 复杂度: 0(1)
        System.out.println("Hashset after removing 'Apple': " + hashSet);

        //清空HashSet
        hashSet.clear();//复杂度：0(n)
        System.out.println("HashSet after clearing:" + hashSet);
    }
}
