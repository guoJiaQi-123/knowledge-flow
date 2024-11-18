package com.dataStructure.dataStructure.blockingqueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双锁实现阻塞队列
 */
@SuppressWarnings("all")
public class BlockingQueue2<E> implements BlockingQueue<E> {
    private final E[] array;
    private int tail;
    private int head;
    /**
     *   解释为何使用AtomicInteger类型定义size变量：
     *
     *   如果直接定义int类型的size，在改变size的值时，size++相当于三个步骤：
     *                 1. 读取成员变量size的值  5
     *                 2. 自增 6
     *                 3. 结果写回成员变量size 6
     *   此时，在多线程环境下，这种非原子性操作是线程不安全的，因此，使用AtomicInteger类型
     *   保证在修改size值的时候的原子性
     */
    private final AtomicInteger size = new AtomicInteger();

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    //第一个锁，控制尾部offer方法并行执行
    private final ReentrantLock tailLock = new ReentrantLock();
    private final Condition tailWaits = tailLock.newCondition();

    //第二个锁，控制头部poll方法并行执行
    private final ReentrantLock headLock = new ReentrantLock();
    private final Condition headWaits = headLock.newCondition();

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public void offer(E value) throws InterruptedException {
        tailLock.lockInterruptibly();
        //定义一个变量，存放添加前元素的个数
        int c;
        try {
            // 1. 队列满则等待
            while (isFull()) {
                tailWaits.await();
            }

            // 2. 不满则入队
            array[tail] = value;
            if (++tail == array.length) {
                tail = 0;
            }

            // 3. 修改 size的值
            //此时的c为原来的（添加之前）队列中的元素个数
            c = size.getAndIncrement(); //相当于size++
            //如果c + 1后任然小于队列容量，则说明在添加元素后队列任然没有满，可以继续唤醒等待队列非满的offer线程
            if (c + 1 < array.length) {
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }

        // 4. 如果从0变为非空，由offer这边唤醒等待非空的poll线程
        //只有在队列由空，调用offer到非空队列时，才从offer方法中唤醒处在等待状态的poll线程（等待非空），其余情况则在poll线程中使用级联唤醒
        if (c == 0) {
            headLock.lock();//解决死锁问题
            try {
                headWaits.signal();//唤醒等待非空的线程
            } finally {
                headLock.unlock();
            }
        }
    }

    @Override
    public E poll() throws InterruptedException {
        E value;
        headLock.lockInterruptibly();
        //设置一个变量，存放取走前的元素个数
        int c;
        try {
            // 1. 队列空则等待
            while (isEmpty()) {
                headWaits.await();
            }

            // 2. 非空则出队
            value = array[head];
            array[head] = null; // help GC
            if (++head == array.length) {
                head = 0;
            }

            // 3. 修改 size，此时的c为取走元素前队列中元素的个数
            c = size.getAndDecrement();
            //c - 1以后如果任然大于零，说明队列在取走元素后任不为空，可以继续唤醒等待非空的poll线程
            if (c - 1 > 0) {
                headWaits.signal();
            }

        } finally {
            headLock.unlock();
        }

        // 4. 队列从满->不满时 由poll唤醒等待不满的 offer 线程
        //只有当队列从满队列调用poll方法成为不满队列时，才去在poll方法中唤醒等待非满的线程，其余情况则从offer中使用级联唤醒
        if (c == array.length) {
            tailLock.lock();//解决死锁问题
            try {
                tailWaits.signal();//唤醒等待非满的线程
            } finally {
                tailLock.unlock();
            }
        }
        return value;
    }

    @Override
    public boolean offer(E value, long timeout) throws InterruptedException {
        return false;
    }

}
