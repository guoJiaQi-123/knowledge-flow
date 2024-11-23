package com.tyut.cas;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

/**
 * @version v1.0
 * @author OldGj 2024/11/23
 * @apiNote 自己使用CAS实现一个updateAndGet方法
 */
public class Test3 {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(5);
        int updateValue = updateAndGet(i, p -> p * 5);
        System.out.println(updateValue);
    }

    /**
     * 自己使用CAS实现一个updateAndGet方法
     * @param i 原子整数
     * @param operator 处理逻辑
     * @return
     */
    public static int updateAndGet(AtomicInteger i, IntUnaryOperator operator) {
        // CAS操作
        while (true) {
            int prev = i.get();
            int next = operator.applyAsInt(prev);
            // 如果prev和AtomicInteger里面维护的value一致，说明没有别的线程对当前value进行修改，则设置最新值为next
            // 否则，说明别的线程对当前value进行了修改，则返回false进入下一轮循环，直到当前值没有被修改 -> CAS操作
            if (i.compareAndSet(prev, next)) {
                return next;
            }
        }
    }

}
