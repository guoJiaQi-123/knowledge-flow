package com.tyut.design.E1_singleton;

/**
 * @version v1.0
 * @author OldGj 2024/10/22
 * @apiNote 单例模式-饿汉式
 */
public class Singleton2 {

    private Singleton2() {

    }

    private static final Singleton2 instance;

    // 在静态代码快中创建对象实例
    static {
        instance = new Singleton2();
    }

    public static Singleton2 newInstance() {
        return instance;
    }


}
