package com.tyut.design.E1_singleton;

/**
 * @version v1.0
 * @author OldGj 2024/10/22
 * @apiNote 单例模式-饿汉式
 */
public class Singleton1 {

    // 1. 私有化构造方法
    private Singleton1() {

    }


    // 2. 在类的内部创建实例化对-通过静态成员变量创建
    private final static Singleton1 instance = new Singleton1();


    // 3. 使用一个public方法将类中创建的唯一一个实例化对象对外暴露出去
    public static Singleton1 newInstance() {
        return instance;
    }


}
