package com.tyut.design.E1_singleton;

/**
 * @version v1.0
 * @author OldGj 2024/10/22
 * @apiNote 单例模式-最优秀的写法-双重检查锁-懒汉式
 */
public class Singleton5 {

    private static volatile Singleton5 instance;

    private Singleton5() {

    }

    // 双重检查锁，即保证了懒汉式加载，而且是线程安全的，并且性能没有损失
    public static Singleton5 newInstance() {
        // 第一重判断
        if (instance == null) {
            synchronized (Singleton5.class) {
                // 第二重判断
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

}
