package com.tyut.set;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EnumSet;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote EnumSet方法示例
 */
public class MainEnumSet {
    public static void main(String[] args) {
        //创建一个EnumSet实例，存储Season枚举类型的元素
        EnumSet<Season> enumSet = EnumSet.allOf(Season.class); // 复杂度: 0(1)

        //打印EnumSet中的元素
        System.out.println("EnumSet: " + enumSet);

        //获取EnumSet的大小
        int size = enumSet.size();// 复杂度：0(1)
        System.out.println("Size of EnumSet:" + size);

        //检查EnumSet是否为空
        boolean isEmpty = enumSet.isEmpty(); // 复杂度:0(1)
        System.out.println("Is EnumSet empty: " + isEmpty);

        //检查EnumSet中是否包含某个元素
        boolean contains = enumSet.contains(Season.SUMMER); // 复杂度: O(1)
        System.out.println("EnumSet contains 'SUMMER': " + contains);

        //删除EnumSet中的元素
        enumSet.remove(Season.WINTER); // 复杂度:0(1)
        System.out.println("EnumSet after removing 'WINTER': " + enumSet);

        //清空EnumSet
        enumSet.clear();// 复杂度：0(1)
        System.out.println("EnumSet after clearing:" + enumSet);
    }
}
