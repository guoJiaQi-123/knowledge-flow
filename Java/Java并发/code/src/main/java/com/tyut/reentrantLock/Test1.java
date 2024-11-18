package com.tyut.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @version v1.0
 * @author OldGj 2024/11/18
 * @apiNote ReentrantLock 可重入示例
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    /*
        可重入是指同一个线程如果首次获得了这把锁，那么因为它是这把锁的拥有者，因此有权利再次获取这把锁
        如果是不可重入锁，那么第二次获得锁时，自己也会被锁挡住。
     */
    private static final ReentrantLock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        LOCK.lock();
        try {
            log.debug("entry main");
            m1();
        } finally {
            LOCK.unlock();
        }
    }

    public static void m1() {
        LOCK.lock();
        try {
            // 可重入
            log.debug("entry m1");
            m2();
        } finally {
            LOCK.unlock();
        }
    }

    public static void m2() {
        LOCK.lock();
        try {
            log.debug("entry m2");
        } finally {
            LOCK.unlock();
        }
    }
}
