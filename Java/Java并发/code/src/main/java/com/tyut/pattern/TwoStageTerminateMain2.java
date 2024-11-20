package com.tyut.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @version v1.0
 * @author OldGj 2024/11/11
 * @apiNote 两阶段终止模式 使用 volatile 关键字保证可见性
 */
@Slf4j(topic = "c.TwoStageTerminateMain")
public class TwoStageTerminateMain2 {
    public static void main(String[] args) throws InterruptedException {
        TwoStageTerminate2 twoStageTerminate = new TwoStageTerminate2();
        twoStageTerminate.start();
        Thread.sleep(3500);
        twoStageTerminate.stop();
    }
}


@Slf4j(topic = "c.TwoStageTerminate")
class TwoStageTerminate2 {
    private Thread monitor;
    private volatile boolean stop = false;

    /**
     * 线程启动
     */
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                if (stop) {
                    log.debug("处理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("执行记录状态");
                } catch (InterruptedException e) { // 如果在sleep期间被打断，会执行catch块中的代码
                }
            }
        }, "monitor");
        monitor.start();
    }

    /**
     * 线程停止
     */
    public void stop() {
        log.debug("暂停");
        stop = true;
        monitor.interrupt();
    }
}
