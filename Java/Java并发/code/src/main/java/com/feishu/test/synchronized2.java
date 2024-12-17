package com.feishu.test;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j(topic = "c.synchronized2")
public class synchronized2 {
    /*
        wrong 方法中试图对一个静态对象加对象级别的 synchronized 锁，并不能保证线程安全。
     */

    public static void main(String[] args) {
        synchronized2 demo = new synchronized2();
        System.out.println(demo.wrong(1000000));
        System.out.println(demo.right(1000000));
    }

    public int wrong(int count) {
        Data.reset();
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new Data().wrong());
        return Data.getCounter();
    }

    public int right(int count) {
        Data.reset();
        IntStream.rangeClosed(1, count).parallel().forEach(i -> new Data().right());
        return Data.getCounter();
    }

    private static class Data {

        @Getter
        private static int counter = 0;

        private static Object locker = new Object();

        public static int reset() {
            counter = 0;
            return counter;
        }

        // counter是静态对象，在方法上加的synchronized是实例化对象级别的锁，不能保证线程安全
        public synchronized void wrong() {
            counter++;
        }

        public void right() {
            synchronized (locker) {
                counter++;
            }
        }

    }
}