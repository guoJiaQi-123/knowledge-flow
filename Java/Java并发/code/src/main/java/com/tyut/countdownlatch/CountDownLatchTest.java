package com.tyut.countdownlatch;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version v1.0
 * @author OldGj 2024/12/11
 * @apiNote CountDownLatch
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService service = Executors.newFixedThreadPool(10);
        String[] array = new String[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int k = i;
            service.submit(() -> {
                for (int j = 0; j <= 100; j++) {
                    int anInt = random.nextInt(100);
                    try {
                        Thread.sleep(anInt);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    array[k] = j + "%";
                    System.out.print("\r " + Arrays.toString(array));
                }
                latch.countDown();
            });
        }
        latch.await();
        System.out.println("\n 游戏开始");
    }
}
