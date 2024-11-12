package com.tyut.util;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote 线程睡眠工具类
 */
public class Sleeper {

    public static void sleep(int s) {
        try {
            Thread.sleep(s * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
