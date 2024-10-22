package com.tyut.design.E1_singleton;

import java.io.Serializable;

/**
 * @version v1.0
 * @author OldGj 2024/10/22
 * @apiNote 单例模式-推荐使用方法-私有静态内部类-懒汉式
 */
public class Singleton6 implements Serializable {

    private Singleton6() {

    }

    private static class SingletonInstance {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 newInstance() {
        return SingletonInstance.INSTANCE;
    }

    /**
     * 下面是为了解决序列化反序列化破解单例模式
     * readResolve 方法是一个特殊的方法，用于在反序列化过程中自定义对象的返回逻辑。
     */
    private Object readResolve() {
        return SingletonInstance.INSTANCE;
    }

}
