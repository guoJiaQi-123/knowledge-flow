package com.tyut.pattern;

import com.tyut.util.Sleeper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/11/16
 * @apiNote 保护性暂停模式
 */
@Slf4j(topic = "c.ProtectivePause")
public class ProtectivePause {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        // t1需要等待t2计算出结果后，拿到t2中的值才能继续执行
        GuardedObject guardedObject = new GuardedObject();

        new Thread(() -> {
            log.debug("执行等待");
            List<Integer> list = (List<Integer>) guardedObject.get();
            for (Integer i : list) {
                log.debug(String.valueOf(i));
            }
        }, "t1").start();

        new Thread(() -> {
            log.debug("计算结果");
            Sleeper.sleep(2);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            guardedObject.complete(list);
        }, "t2").start();

    }
}



