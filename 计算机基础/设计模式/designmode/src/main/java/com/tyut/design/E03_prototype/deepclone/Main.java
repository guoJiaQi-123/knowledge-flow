package com.tyut.design.E03_prototype.deepclone;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 原型对象
        Citation citation = new Citation();
        Student student = new Student("小猫");
        citation.setStudent(student);
        // 克隆对象
        Citation clone = citation.clone();
        // 修改克隆对象中的引用数据类型
        clone.getStudent().setName("小狗");

        citation.show();
        clone.show();
    }
}

