package com.tyut.pattern;

import java.util.concurrent.locks.LockSupport;

/**
 * @version v1.0
 * @author OldGj 2024/11/19
 * @apiNote 循环打印 交替输出  park/unpark 实现
 * 需求：线程 1 输出 a 5 次，线程 2 输出 b 5 次，线程 3 输出 c 5 次。现在要求输出 abcabcabcabcabc 怎么实现
 */
public class Loop3 {
    public static void main(String[] args) {

        ParkUnPark parkUnPark = new ParkUnPark(5);

        Thread t1 = new Thread(() -> {
            parkUnPark.print("a");
        });

        Thread t2 = new Thread(() -> {
            parkUnPark.print("b");
        });

        Thread t3 = new Thread(() -> {
            parkUnPark.print("c\n");
        });

        parkUnPark.setThreads(t1, t2, t3);
        parkUnPark.start();
    }
}

class ParkUnPark {
    private final int loopSize; // 循环次数
    private Thread[] threads; // 线程集合

    public ParkUnPark(int loopSize) {
        this.loopSize = loopSize;
    }

    public void setThreads(Thread... threads) {
        this.threads = threads;
    }

    public void print(String str) {
        for (int i = 0; i < loopSize; i++) {
            LockSupport.park(); // 当前线程阻塞
            System.out.print(str);
            LockSupport.unpark(nextThread()); // 唤醒下一个线程「从线程集合动态的去算下一个线程是哪个」
        }
    }

    /**
     * 计算下一个线程
     * @return 下一个线程
     */
    private Thread nextThread() {
        Thread current = Thread.currentThread();
        int index = 0;
        for (int i = 0; i < threads.length; i++) {
            if (threads[i] == current) {
                index = i;
                break;
            }
        }
        if (index < threads.length - 1) {
            return threads[index + 1];
        } else {
            return threads[0];
        }
    }

    /**
     * 启动所有线程，并且唤醒第一个线程
     */
    public void start() {
        for (Thread thread : threads) {
            thread.start();
        }
        LockSupport.unpark(threads[0]);
    }
}