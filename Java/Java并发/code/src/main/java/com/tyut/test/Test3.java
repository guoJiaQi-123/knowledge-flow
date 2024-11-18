package com.tyut.test;

import com.tyut.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

/**
 * @version v1.0
 * @author OldGj 2024/11/16
 * @apiNote wait/notifyAll
 */
@Slf4j(topic = "c.Test3")
public class Test3 {
    public static final Object lock = new Object();

    @SuppressWarnings("all")
    public static void main(String[] args) {
        new Thread(() -> {
            log.debug("执行");
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("{}执行其他操作", Thread.currentThread().getName());
        }, "t1").start();

        new Thread(() -> {
            log.debug("执行");
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("{}执行其他操作", Thread.currentThread().getName());
        }, "t2").start();

        Sleeper.sleep(2);
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
