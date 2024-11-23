package com.tyut.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version v1.0
 * @author OldGj 2024/11/23
 * @apiNote 原子整数
 */
public class Test2 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(5);
        // lambda表达式 参数：读取到的值，表达式：要怎么更新这个值
        int updateValue = i.updateAndGet(value -> value * 10);
        System.out.println(updateValue);

    }
}
