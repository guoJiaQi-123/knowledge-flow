package com.tyut.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote TreeSet方法示例
 */
public class MainTreeSet {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //创建一个TreeSet实例，存储Integer类型的元素、
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder()); // 复杂度: 0(1)

        //向TreeSet添加元素
        treeSet.add(5);// 复杂度:0(Log n)
        treeSet.add(2);//复杂度：0(Log n)
        treeSet.add(8); // 复杂度:0(Log n)

        //打印TreeSet中的元素(按升序排列)
        System.out.println("TreeSet:" + treeSet);

        //获取TreeSet的大小
        int size = treeSet.size(); // 复杂度: 0(1)
        System.out.println("Size of TreeSet: " + size);

        //检查TreeSet是否为空
        boolean isEmpty = treeSet.isEmpty(); // 复杂度:0(1)
        System.out.println("Is TreeSet empty: " + isEmpty);

        //获取TreeSet中的最小元素
        int minValue = treeSet.first(); // 复杂度: 0(1)
        System.out.println("Min value in TreeSet:" + minValue);

        //获取TreeSet中的最大元素
        int maxValue = treeSet.last();// 复杂度:0(1)
        System.out.println("Max value in Tree5et:" + maxValue);

        //检查TreeSet中是否包含某个元素
        boolean contains = treeSet.contains(5); // 复杂度: 0(Log n)
        System.out.println("Tree5et contains" + contains);

        //删除TreeSet中的元素
        treeSet.remove(2);// 复杂度:0(Log n)
        System.out.println("TreeSet after removing'2':" + treeSet);

        //清空TreeSet
        treeSet.clear();//复杂度：0(n)
        System.out.println("TreeSet after clearing:" + treeSet);
    }
}
