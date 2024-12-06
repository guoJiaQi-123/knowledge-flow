package com.tyut.readwritelock;

import com.tyut.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @version v1.0
 * @author OldGj 2024/12/6
 * @apiNote 读写锁
 */
@Slf4j(topic = "c.ReadWriteLock")
public class ReadWriteLock {

    public static void main(String[] args) {
        new Thread(ReadWriteLock::read, "t1").start();
        new Thread(ReadWriteLock::write, "t2").start();
    }


    private static final ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.ReadLock r = rw.readLock();
    private static final ReentrantReadWriteLock.WriteLock w = rw.writeLock();

    public static void read() {
        log.debug("添加读锁");
        r.lock();
        try {
            log.debug("读操作");
            Sleeper.sleep(1);
        } finally {
            log.debug("释放读锁");
            r.unlock();
        }
    }

    public static void write() {
        log.debug("添加写锁");
        w.lock();
        try {
            log.debug("写操作");
            Sleeper.sleep(1);
        } finally {
            log.debug("释放写锁");
            w.unlock();
        }
    }
}
