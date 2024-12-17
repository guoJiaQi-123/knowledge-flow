package com.feishu.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Interesting")
public class Interesting {
    /*
        正确的做法应该是，为 add 和 compare 都加上方法锁，确保 add 方法执行时，compare 无法读取 a 和 b：
     */

    volatile int a = 1;
    volatile int b = 1;

    public static void main(String[] args) {
        Interesting interesting = new Interesting();
        new Thread(interesting::add).start();
        new Thread(interesting::compare).start();
    }

    public synchronized void add() {
        log.info("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        log.info("add done");
    }

    public void compare() {
        log.info("compare start");
        for (int i = 0; i < 10000; i++) {
            //a始终等于b吗？
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a > b);
                //最后的a>b应该始终是false吗？
            }
        }
        log.info("compare done");
    }

}