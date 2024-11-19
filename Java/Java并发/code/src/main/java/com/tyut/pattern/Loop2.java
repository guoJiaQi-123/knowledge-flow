package com.tyut.pattern;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/19
 * @apiNote 循环打印 交替输出  ReentrantLock 实现
 * 需求：线程 1 输出 a 5 次，线程 2 输出 b 5 次，线程 3 输出 c 5 次。现在要求输出 abcabcabcabcabc 怎么实现
 */
public class Loop2 {
    public static void main(String[] args) {
        AwaitSignal awaitSignal = new AwaitSignal(5);
        Condition a = awaitSignal.newCondition();
        Condition b = awaitSignal.newCondition();
        Condition c = awaitSignal.newCondition();
        new Thread(() -> {
            awaitSignal.print("a", a, b);
        }).start();

        new Thread(() -> {
            awaitSignal.print("b", b, c);
        }).start();

        new Thread(() -> {
            awaitSignal.print("c", c, a);
        }).start();

        sleep(1);
        try {
            awaitSignal.lock();
            a.signal(); // 主线程率先唤醒a休息室的线程
        } finally {
            awaitSignal.unlock();
        }
    }
}


class AwaitSignal extends ReentrantLock {
    public AwaitSignal(int loopSize) {
        this.loopSize = loopSize;
    }

    private final int loopSize;

    public void print(String str, Condition curr, Condition next) {
        for (int i = 0; i < loopSize; i++) {
            try {
                lock();
                curr.await(); // 自己进入休息室
                System.out.print(str);
                next.signal(); // 唤醒下一个休息室
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                unlock();
            }
        }
    }
}
