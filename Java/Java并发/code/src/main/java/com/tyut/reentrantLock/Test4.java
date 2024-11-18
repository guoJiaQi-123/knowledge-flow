package com.tyut.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/18
 * @apiNote ReentrantLock 锁超时特性 「带超时时间」
 */
@Slf4j(topic = "c.Test4")
public class Test4 {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            log.debug("启动...");
            try {
                if (!lock.tryLock(3, TimeUnit.SECONDS)) { // 尝试获得锁 等待3秒
                    log.debug("获取失败，立刻返回");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.debug("在等待锁的过程中被打断");
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
            sleep(2); // 主线程获取锁2秒
        } finally {
            log.debug("释放了锁");
            lock.unlock();
        }
    }
}
