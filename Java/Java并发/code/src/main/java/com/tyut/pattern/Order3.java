package com.tyut.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version v1.0
 * @author OldGj 2024/11/19
 * @apiNote 同步模式之顺序控制   ReentrantLock的条件变量 await/signal 实现
 * 需求：固定运行顺序，一个线程打印2，一个线程打印1，现在要求 必须先 2 后 1 打印
 */
@Slf4j(topic = "c.Order")
public class Order3 {
    static final ReentrantLock lock = new ReentrantLock();
    static final Condition condition = lock.newCondition();
    static boolean t2IsRun = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                lock.lock(); // 加锁
                while (!t2IsRun) {
                    try {
                        condition.await(); // 等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("1");
            } finally {
                lock.unlock();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                lock.lock();
                log.debug("2");
                t2IsRun = true;
                condition.signal(); // 唤醒处于等待的线程
            } finally {
                lock.unlock();
            }
        }, "t2");


        t1.start();
        t2.start();
    }
}
