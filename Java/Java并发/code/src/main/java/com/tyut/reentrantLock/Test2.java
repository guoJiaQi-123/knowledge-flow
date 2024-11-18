package com.tyut.reentrantLock;

import com.tyut.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/18
 * @apiNote ReentrantLock 可打断锁
 */
@Slf4j(topic = "c.Test2")
public class Test2 {
    public static final ReentrantLock LOCK = new ReentrantLock();

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                log.debug("尝试获得锁");
                LOCK.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("等待锁的过程中被打断");
                return;
            }
            try {
                log.debug("成功获得锁");
            } finally {
                LOCK.unlock();
            }
        }, "t1");

        try {
            LOCK.lock(); // 主线程先加锁
            log.debug("获得了锁");
            t1.start();
            sleep(2);
            log.debug("执行打断操作");
            t1.interrupt(); // 会把处于等待锁状态的lock打断
        } finally {
            LOCK.unlock();
        }
    }
}
