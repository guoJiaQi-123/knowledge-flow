package com.tyut.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version v1.0
 * @author OldGj 2024/11/23
 * @apiNote 原子整数 AtomicInteger
 */
@Slf4j(topic = "c.Test1")
public class Test1 {
    public static void main(String[] args) {
        AtomicInteger value = new AtomicInteger(0);
        System.out.println(value.incrementAndGet()); // 1
        System.out.println(value.getAndIncrement()); // 1 value = 2
        System.out.println(value.getAndAdd(10)); // 2 value = 12
        System.out.println(value.addAndGet(10)); // 22
        System.out.println(value.get()); // 22
    }
}
