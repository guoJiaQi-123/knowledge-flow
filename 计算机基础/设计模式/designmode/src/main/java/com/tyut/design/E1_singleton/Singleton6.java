package com.tyut.design.E1_singleton;

/**
 * @version v1.0
 * @author OldGj 2024/10/22
 * @apiNote 单例模式-推荐使用方法-私有静态内部类-懒汉式
 */
public class Singleton6 {

    private Singleton6() {

    }

    private static class SingletonInstance {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 newInstance() {
        return SingletonInstance.INSTANCE;
    }

}
