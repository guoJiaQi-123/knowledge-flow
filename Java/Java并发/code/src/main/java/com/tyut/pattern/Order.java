package com.tyut.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @version v1.0
 * @author OldGj 2024/11/19
 * @apiNote 同步模式之顺序控制   wait/notifyAll 实现
 * 需求：固定运行顺序，一个线程打印2，一个线程打印1，现在要求 必须先 2 后 1 打印
 */
@Slf4j(topic = "c.Order")
public class Order {
    static final Object lock = new Object();
    static boolean t2IsRun = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                // 如果t2还没有运行，则t1进入waitSet等待
                while (!t2IsRun) {
                    try {
                        lock.wait(); // 进入等待并且释放lock锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                log.debug("2");
                t2IsRun = true;
                lock.notifyAll(); // 唤醒处于等待的线程
            }
        }, "t2");


        t1.start();
        t2.start();
    }
}
