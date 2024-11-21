package com.tyut.test;

/**
 * @version v1.0
 * @author OldGj 2024/11/21
 * @apiNote happens-before规则
 * 线程 start 前对变量的写，对该线程开始后对该变量的读可见
 */
public class Test9 {
    static int x;

    public static void main(String[] args) {
        x = 10; // 线程开始前的写对线程开始后可见
        new Thread(() -> {
            System.out.println(x);
        }, "t2").start();
    }
}
