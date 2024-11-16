package com.tyut.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * 保护性暂停模式
 */
@Slf4j(topic = "c.GuardedObject")
public class GuardedObject {

    private static final Object lock = new Object();
    private Object response;

    public Object get() {
        synchronized (lock) {
            // 条件不满足则等待
            while (response == null) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return response;
        }
    }

    /*
            带等待时间
     */
    public Object get(long timeout) {
        synchronized (lock) {
            // 条件不满足则等待
            long startTime = System.currentTimeMillis();// 开始时间
            long passedTime = 0;
            while (response == null) {
                long waitTime = timeout - passedTime; // 还需要等待的时间 = 总共需要等待的时间-已经等待的时间
                // 如果还需要等待的时间<=0了，那么说明已经超时，退出循环即可
                if (waitTime <= 0) {
                    break;
                }
                try {
                    lock.wait(waitTime); // 等待
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                passedTime = System.currentTimeMillis() - startTime; // 已经等待的时间「经历的时间」
            }
            return response;
        }
    }


    public void complete(Object response) {
        synchronized (lock) {
            // 条件满足，通知等待线程
            this.response = response;
            lock.notifyAll();
        }
    }

}
