package com.tyut.test;

/**
 * @version v1.0
 * @author OldGj 2024/11/21
 * @apiNote happens-before 规则
 * 线程结束前对变量的写，对其它线程得知它结束后的读可见
 */
public class TestA {
    static int x;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            x = 10;
        }, "t1"); // 该线程结束后会把该线程工作空间内的内容全部同步到主存
        t1.start();

        t1.join();
        System.out.println(x);
    }
}
