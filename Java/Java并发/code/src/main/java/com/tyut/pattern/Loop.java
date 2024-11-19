package com.tyut.pattern;

/**
 * @version v1.0
 * @author OldGj 2024/11/19
 * @apiNote 循环打印 交替输出  synchronized 实现
 * 需求：线程 1 输出 a 5 次，线程 2 输出 b 5 次，线程 3 输出 c 5 次。现在要求输出 abcabcabcabcabc 怎么实现
 */
public class Loop {
    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify(1, 5);
        new Thread(() -> {
            waitNotify.print("a", 1, 2);
        }).start();

        new Thread(() -> {
            waitNotify.print("b", 2, 3);
        }).start();

        new Thread(() -> {
            waitNotify.print("c", 3, 1);
        }).start();
    }
}


class WaitNotify {

    /**
     * 打印当前线程的字母
     * @param srt 当前线程的字母
     * @param curr 当前标志位
     * @param next 下一个标志位
     */
    public void print(String srt, int curr, int next) {
        for (int i = 0; i < loopSize; i++) {
            synchronized (this) {
                while (flag != curr) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(srt);
                flag = next;
                this.notifyAll();
            }
        }
    }

    public WaitNotify(int flag, int loopSize) {
        this.flag = flag;
        this.loopSize = loopSize;
    }

    private int flag;  // 1=>打印a 2=>打印b 3=>打印c

    private final int loopSize;
}
