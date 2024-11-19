package com.tyut.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version v1.0
 * @author OldGj 2024/11/19
 * @apiNote 条件变量
 */
@Slf4j(topic = "c.Test5")
public class Test5 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        // 条件变量  休息室
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        lock.lock();
        try {
            condition1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        condition1.signal();
        condition1.signalAll();
    }
}
