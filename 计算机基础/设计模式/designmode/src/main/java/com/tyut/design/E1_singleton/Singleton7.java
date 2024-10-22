package com.tyut.design.E1_singleton;

/**
 * @version v1.0
 * @author OldGj 2024/10/22
 * @apiNote 单例模式-枚举实现-推荐使用-饿汉式
 */
public class Singleton7 {

    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}


enum Singleton {

    INSTANCE;

    void doSomething() {
        // 单例的具体业务逻辑
    }

}