package com.dataStructure.dataStructure.blockingqueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单锁实现
 * @param <E>
 */
@SuppressWarnings("all")
public class BlockingQueue1<E> implements BlockingQueue<E> {
    private final E[] array;
    private int tail;
    private int head;
    private int size;

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private ReentrantLock lock = new ReentrantLock();
    private Condition tailWaits = lock.newCondition();
    private Condition headWaits = lock.newCondition();

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == array.length;
    }

    @Override
    public void offer(E value) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWaits.await();
            }
            array[tail] = value;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();//唤醒等待非空的线程
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E value, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long t = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()) {
                if (t <= 0) {
                    return false;
                }
                t = tailWaits.awaitNanos(t);   //返回值  剩余时间
            }
            array[tail] = value;
            if (++tail == array.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();//唤醒等待非空的线程
        } finally {
            lock.unlock();
        }
        return true;
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            E value = array[head];
            array[head] = null; // help GC
            if (++head == array.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();//唤醒等待非满的线程
            return value;
        } finally {
            lock.unlock();
        }
    }


}
