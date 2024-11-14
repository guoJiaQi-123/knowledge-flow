package com.tyut.test;

import com.tyut.util.Joiner;
import lombok.extern.slf4j.Slf4j;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote test1
 */
@Slf4j(topic = "c.Test1")
public class Test1 {

    static int count = 0;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // synchronized就是对象锁，只能锁对象，如果synchronized加在成员方法上，表示锁的是this对象
                // synchronized如果加在静态方法上，表示锁的是类对象
                synchronized (lock) { // 对象锁
                    count++;
                }
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    count--;
                }
            }
        }, "t2");

        t1.start();
        t2.start();
        Joiner.join(t1);
        Joiner.join(t2);
        System.out.println(count);
    }
}
