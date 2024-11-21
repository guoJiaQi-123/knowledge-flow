package com.tyut.test;

/**
 * @version v1.0
 * @author OldGj 2024/11/21
 * @apiNote happens-before规则
 * 线程对 volatile 变量的写，对接下来其它线程对该变量的读可见
 */
public class Test8 {
    volatile static int x;

    public static void main(String[] args) {
        new Thread(() -> {
            x = 10;
        }, "t1").start();

        new Thread(() -> {
            System.out.println(x);
        }, "t2").start();
    }
}
