package com.tyut.pool;

import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args) {
        /**
         * 参数一：核心线程数
         * 参数二：超时时间
         * 参数三：时间单位
         * 参数四：任务队列容量
         * 参数五：任务队列满了以后，多余出来的任务需要执行的拒绝策略
         */
        ThreadPool threadPool = new ThreadPool(1, 1000, TimeUnit.MILLISECONDS, 1, (queue, task) -> {
            //死等
//                    queue.put(task);
            //带超时等待
//            queue.offer(task, 1500, TimeUnit.MILLISECONDS);
            //让调用者放弃任务执行
//            System.out.println("放弃：" + task);
            //让调用者抛出异常
//            throw new RuntimeException("任务执行失败" + task);
            //让调用者自己执行任务
            task.run();
        });
        for (int i = 0; i < 3; i++) {
            int j = i;
            threadPool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().toString() + "执行任务：" + j);
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}