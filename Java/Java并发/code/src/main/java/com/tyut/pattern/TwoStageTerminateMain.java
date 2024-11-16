package com.tyut.pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @version v1.0
 * @author OldGj 2024/11/11
 * @apiNote 两阶段终止模式
 */
@Slf4j(topic = "c.TwoStageTerminateMain")
public class TwoStageTerminateMain {
    public static void main(String[] args) throws InterruptedException {
        TwoStageTerminate twoStageTerminate = new TwoStageTerminate();
        twoStageTerminate.start();
        Thread.sleep(3500);
        twoStageTerminate.stop();
    }
}


@Slf4j(topic = "c.TwoStageTerminate")
class TwoStageTerminate {
    private Thread monitor;

    /**
     * 线程启动
     */
    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    log.debug("处理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("执行记录状态");
                } catch (InterruptedException e) { // 如果在sleep期间被打断，会执行catch块中的代码
                    e.printStackTrace();
                    // 重新设置打断标志
                    current.interrupt();
                }
            }
        });
        monitor.start();
    }

    /**
     * 线程停止
     */
    public void stop() {
        monitor.interrupt();
    }
}
