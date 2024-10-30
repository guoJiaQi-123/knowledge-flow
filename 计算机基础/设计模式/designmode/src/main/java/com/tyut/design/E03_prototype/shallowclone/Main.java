package com.tyut.design.E03_prototype.shallowclone;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype(); // 原型对象
        Realizetype clone = realizetype.clone(); // 克隆对象
        System.out.println(clone == realizetype); // false 浅克隆
    }
}
