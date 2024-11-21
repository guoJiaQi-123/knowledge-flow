package com.tyut.test;

/**
 * @version v1.0
 * @author OldGj 2024/11/21
 * @apiNote happens-before
 * 具有传递性，如果 x hb-> y 并且 y hb-> z 那么有 x hb-> z ，配合 volatile 的防指令重排，有下面的例子
 */
public class TestC {
    volatile static int x;
    static int y;

    public static void main(String[] args) {
        new Thread(() -> {
            y = 10;
            x = 20; // 被volatile修饰，保证了指令不被重排
        }, "t1").start();

        new Thread(() -> {
            // x=20 对 t2 可见, 同时 y=10 也对 t2 可见
            System.out.println(x);
        }, "t2").start();
    }
}
