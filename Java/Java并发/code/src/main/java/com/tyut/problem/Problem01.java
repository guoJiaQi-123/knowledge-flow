package com.tyut.problem;

import lombok.extern.slf4j.Slf4j;

import static com.tyut.util.Sleeper.sleep;
import static com.tyut.util.Joiner.join;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote 习题一 有缺陷
 */
@Slf4j(topic = "c.Problem01")
public class Problem01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("洗水壶");
            sleep(1);
            log.debug("烧开水");
            sleep(5);
        }, "老王");
        t1.start();

        Thread t2 = new Thread(() -> {
            log.debug("洗茶壶");
            sleep(1);
            log.debug("洗茶杯");
            sleep(1);
            log.debug("拿茶叶");
            sleep(1);
            join(t1);
            log.debug("泡茶叶");
        }, "小王");

        t2.start();
    }


}
