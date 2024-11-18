package com.tyut.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/18
 * @apiNote park/unpark
 */
@Slf4j(topic = "c.Test4")
public class Test4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("start...");
            sleep(1);
            log.debug("park...");
            LockSupport.park();
            log.debug("resume...");
        }, "t1");
        t1.start();

        sleep(3);
        log.debug("unpark...");
        LockSupport.unpark(t1); // 主线程唤醒了被park的t1线程
    }
}
