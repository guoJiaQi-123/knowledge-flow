package com.tyut.set;

import java.util.LinkedHashSet;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote LinkedHashSet方法示例
 */
public class MainLinkedHashSet {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //创建一个LinkedHashSet实例，存储String类型的元素
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();// 复杂度: O(1)

        //向LinkedHashSet添加元素
        linkedHashSet.add("Apple");// 复杂度: 0(1)
        linkedHashSet.add("Banana");// 复杂度: 0(1)
        linkedHashSet.add("Cherry"); // 复杂度: 0(1)

        //打印LinkedHashSet中的元素（按添加顺序排列)
        System.out.println("LinkedHashSet:" + linkedHashSet);

        //获取LinkedHashSet的大小
        int size = linkedHashSet.size(); // 复杂度:0(1)
        System.out.println("Size of LinkedHashSet:" + size);

        //检查LinkedHashSet是否为空
        boolean isEmpty = linkedHashSet.isEmpty(); // 复杂度: 0(1)
        System.out.println("Is LinkedHashSet empty:" + isEmpty);

        //检查LinkedHashSet中是否包含某个元素
        boolean contains = linkedHashSet.contains("Banana");// 复杂度:O(1)
        System.out.println("LinkedHashSet contains 'Banana': " + contains);

        //删除LinkedHashSet中的元素
        linkedHashSet.remove("Apple");// 复杂度：0(1)
        System.out.println("LinkedHashSet after removing 'Apple': " + linkedHashSet);

        //清空LinkedHashSet
        linkedHashSet.clear();//复杂度：O(n)
        System.out.println("LinkedHashSet after clearing: " + linkedHashSet);
    }
}
