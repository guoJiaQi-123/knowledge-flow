package com.tyut.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/12/5
 * @apiNote AQS不可重入锁
 */
@Slf4j(topic = "c.TestAQS")
public class TestAQS {

    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(() -> {
            lock.lock();
            log.debug("lock...");
            // 不可重入锁
            lock.lock();
            log.debug("lock...");
            sleep(2);
        }, "t1").start();
    }

}

class MyLock implements Lock {

    final class MySync extends AbstractQueuedSynchronizer {
        /**
         * 尝试加锁
         * @param acquires the acquire argument. This value is always the one
         *        passed to an acquire method, or is the value saved on entry
         *        to a condition wait.  The value is otherwise uninterpreted
         *        and can represent anything you like.
         * @return
         */
        @Override
        protected boolean tryAcquire(int acquires) {
            if (acquires == 1) {
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            }
            return false;
        }

        /**
         * 尝试解锁
         * @param acquires the release argument. This value is always the one
         *        passed to a release method, or the current state value upon
         *        entry to a condition wait.  The value is otherwise
         *        uninterpreted and can represent anything you like.
         * @return
         */
        @Override
        protected boolean tryRelease(int acquires) {
            if (acquires == 1) {
                if (getState() == 0) {
                    throw new IllegalMonitorStateException();
                }
                setExclusiveOwnerThread(null);
                setState(0);
                return true;
            }
            return false;
        }

        /**
         * 新建条件变量
         * @return
         */
        protected Condition newCondition() {
            return new ConditionObject();
        }

        /**
         * 当前状态是否为1
         * @return
         */
        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    MySync sync = new MySync();

    @Override
    // 尝试，不成功，进入等待队列
    public void lock() {
        sync.acquire(1);
    }

    @Override
    // 尝试，不成功，进入等待队列，可打断
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    // 尝试一次，不成功返回，不进入队列
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    // 尝试，不成功，进入等待队列，有时限
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    // 释放锁
    public void unlock() {
        sync.release(1);
    }

    @Override
    // 生成条件变量
    public Condition newCondition() {
        return sync.newCondition();
    }
}



