package com.tyut.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote TreeMap使用实例
 */
public class MainTreeMap {
    /*
        TreeMap默认会根据键的自然顺序排序（升序）
     */
    public static void main(String[] args) {
        //创建一个TreeMap用于存储学生姓名和成绩
        Map<String, Integer> studentGrades = new TreeMap<>();

        //添加学生和他们的成绩 乱序添加
        studentGrades.put("Bob", 85);
        studentGrades.put("Alice", 90);
        studentGrades.put("David", 80);
        studentGrades.put("Charlie", 95);

        //打印所有学生及其成绩，按姓名字母顺序排序
        System.out.println("学生成绩列表：");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("学生姓名：" + entry.getKey() + "，成绩：" + entry.getValue());
        }

        //添加新的学生成绩
        studentGrades.put("Eve", 88);

        //打印更新后的成绩列表
        System.out.println("学生成绩列表：");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("学生姓名：" + entry.getKey() + "，成绩：" + entry.getValue());
        }
    }
}
