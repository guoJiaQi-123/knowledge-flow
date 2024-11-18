package com.tyut.test;

import lombok.extern.slf4j.Slf4j;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/18
 * @apiNote 测试死锁deadLock  -> 程序永远无法执行完毕
 */
@Slf4j(topic = "c.Test6")
public class Test6 {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    @SuppressWarnings("all")
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA) {
                sleep(1);
                log.debug("lockA");
                synchronized (lockB) {
                    log.debug("lockB");
                }
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lockB) {
                sleep(2);
                log.debug("lockB");
                synchronized (lockA) {
                    log.debug("lockA");
                }
            }
        }, "t2").start();
    }
}
