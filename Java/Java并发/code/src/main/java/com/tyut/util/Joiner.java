package com.tyut.util;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote 工具类
 */
public class Joiner {
    public static void join(Thread t1) {
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
