package com.tyut.design.E1_singleton;

/**
 * @version v1.0
 * @author OldGj 2024/10/22
 * @apiNote 单例模式-懒汉式
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {

    }

    // 线程安全，但是同步导致该方法效率很低，newInstance方法原本只需要执行一次即可，一般不推荐使用该方法
    public static synchronized Singleton4 newInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }

}
