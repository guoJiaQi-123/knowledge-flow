package com.tyut.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/18
 * @apiNote ReentrantLock 锁超时特性 「获取失败，立刻返回」
 */
@Slf4j(topic = "c.Test3")
public class Test3 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            log.debug("启动...");
            if (!lock.tryLock()) { // 尝试获得锁
                log.debug("获取失败，立刻返回");
                return;
            }
            try {
                log.debug("获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        log.debug("获得了锁");
        lock.lock();
        t1.start();
        try {
            sleep(2);
        } finally {
            lock.unlock();
        }
    }
}
