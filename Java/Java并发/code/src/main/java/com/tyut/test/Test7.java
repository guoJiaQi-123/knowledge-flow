package com.tyut.test;

/**
 * @version v1.0
 * @author OldGj 2024/11/21
 * @apiNote happens-before 规则
 * 1.线程解锁 m 之前对变量的写，对于接下来对 m 加锁的其它线程对该变量的读可见
 */
public class Test7 {
    static int x;
    static Object m = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (m) { // 加锁
                x = 10; // 写
            }
            // 加锁代码结束后会把该代码块中的内容都写入主存
        }, "t1").start();

        new Thread(() -> {
            synchronized (m) { // 同步
                System.out.println(x); // 可见
            }
        }, "t2").start();
    }
}
