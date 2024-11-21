package com.tyut.test;

import lombok.extern.slf4j.Slf4j;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/21
 * @apiNote happens-before 规则
 * 线程 t1 打断 t2（interrupt）前对变量的写，对于其他线程得知 t2 被打断后对变量的读可见
 */
@Slf4j(topic = "c.TestB")
public class TestB {
    static int x;

    public static void main(String[] args) {
        Thread t2 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    log.debug(String.valueOf(x));
                    break;
                }
            }
        }, "t2");
        t2.start();

        new Thread(() -> {
            sleep(1);
            x = 10;
            t2.interrupt();
        }, "t1").start();

        while (!t2.isInterrupted()) {
            Thread.yield();
        }
        log.debug(String.valueOf(x));
    }
}
