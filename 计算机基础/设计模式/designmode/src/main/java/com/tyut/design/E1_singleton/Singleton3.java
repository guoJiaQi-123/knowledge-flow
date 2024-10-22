package com.tyut.design.E1_singleton;

/**
 * @version v1.0
 * @author OldGj 2024/10/22
 * @apiNote 单例模式-懒汉式
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 newInstance() {
        // 多线程环境下，可能创建多个对象实例，线程不安全，生产环境下一般不使用
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }


}
