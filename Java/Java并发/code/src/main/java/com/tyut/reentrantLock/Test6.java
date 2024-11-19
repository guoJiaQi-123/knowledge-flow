package com.tyut.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/19
 * @apiNote ReentrantLock 多条件变量 例子
 */
@Slf4j(topic = "Test6")
public class Test6 {
    static ReentrantLock lock = new ReentrantLock();
    // 等烟条件变量
    static Condition waitCigaretteQueue = lock.newCondition();
    // 等早餐的条件变量
    static Condition waitBreakFastQueue = lock.newCondition();
    static volatile boolean hasCigarette = false;
    static volatile boolean hasBreakfast = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock.lock(); // 加锁
                while (!hasCigarette) {
                    try {
                        waitCigaretteQueue.await(); // 在吸烟者休息室等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("等到了它的烟");
            } finally {
                lock.unlock(); // 解锁
            }
        }, "吸烟者").start();

        new Thread(() -> {
            try {
                lock.lock(); // 加锁
                while (!hasBreakfast) {
                    try {
                        waitBreakFastQueue.await(); // 在等早餐休息室等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("等到了它的早餐");
            } finally {
                lock.unlock();
            }
        }, "吃早餐者").start();

        sleep(1);
        sendBreakfast();
        sleep(1);
        sendCigarette();
    }

    private static void sendCigarette() {
        lock.lock();
        try {
            log.debug("送烟来了");
            hasCigarette = true;
            waitCigaretteQueue.signal(); // 唤醒吸烟者条件变量
        } finally {
            lock.unlock();
        }
    }

    private static void sendBreakfast() {
        lock.lock();
        try {
            log.debug("送早餐来了");
            hasBreakfast = true;
            waitBreakFastQueue.signal(); // 唤醒等早餐条件变量
        } finally {
            lock.unlock();
        }
    }
}
