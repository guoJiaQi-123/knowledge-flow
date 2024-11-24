package com.tyut.pool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 任务队列
 * @param <T>
 */
@SuppressWarnings("all")
class BlockingQueue<T> {
    //阻塞队列，存放任务
    private Deque<T> queue = new ArrayDeque<>();
    //队列的最大容量
    private int capacity;
    //锁 保证多线程下添加任务和获取任务的原子性
    private ReentrantLock lock = new ReentrantLock();
    //生产者条件变量
    private Condition fullWaitSet = lock.newCondition();
    //消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    //构造方法
    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    //超时阻塞获取
    public T poll(long timeout, TimeUnit unit) {
        lock.lock();
        //将时间转换为纳秒
        long nanoTime = unit.toNanos(timeout);
        try {
            while (queue.size() == 0) {
                try {
                    //等待超时依旧没有获取，返回null
                    if (nanoTime <= 0) {
                        return null;
                    }
                    //该方法返回的是剩余时间
                    nanoTime = emptyWaitSet.awaitNanos(nanoTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.pollFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    //阻塞获取
    public T take() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.pollFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    //阻塞添加
    public void put(T t) {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                try {
                    System.out.println(Thread.currentThread().toString() + "等待加入任务队列:" + t.toString());
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().toString() + "加入任务队列:" + t.toString());
            queue.addLast(t);
            emptyWaitSet.signal();
        } finally {
            lock.unlock();
        }
    }

    //超时阻塞添加
    public boolean offer(T t, long timeout, TimeUnit timeUnit) {
        lock.lock();
        try {
            long nanoTime = timeUnit.toNanos(timeout);
            while (queue.size() == capacity) {
                try {
                    if (nanoTime <= 0) {
                        System.out.println("等待超时，加入失败：" + t);
                        return false;
                    }
                    System.out.println(Thread.currentThread().toString() + "等待加入任务队列:" + t.toString());
                    nanoTime = fullWaitSet.awaitNanos(nanoTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().toString() + "加入任务队列:" + t.toString());
            queue.addLast(t);
            emptyWaitSet.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    // 当前任务数
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }

    //从形参接收拒绝策略的put方法
    public void tryPut(RejectPolicy<T> rejectPolicy, T task) {
        lock.lock();
        try {
            if (queue.size() == capacity) { // 如果队列已经满了
                rejectPolicy.reject(this, task); // 执行拒绝策略
            } else {
                System.out.println("加入任务队列：" + task);
                queue.addLast(task);
                emptyWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    }
}