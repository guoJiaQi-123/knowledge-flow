package com.tyut.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

/**
 * @version v1.0
 * @author OldGj 2024/11/19
 * @apiNote 同步模式之顺序控制   park/unpark 实现
 * 需求：固定运行顺序，一个线程打印2，一个线程打印1，现在要求 必须先 2 后 1 打印
 */
@Slf4j(topic = "c.Order2")
public class Order2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park(); // 暂停
            log.debug("1");
        }, "t1");

        Thread t2 = new Thread(() -> {
            log.debug("2");
            LockSupport.unpark(t1); // 恢复暂停 -> 标志位设为1，如果在park时候发现当前标志位为1，则不暂停直接运行
        }, "t2");


        t1.start();
        t2.start();
    }
}
