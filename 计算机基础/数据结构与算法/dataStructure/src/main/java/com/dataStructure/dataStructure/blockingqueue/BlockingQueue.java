package com.dataStructure.dataStructure.blockingqueue;

//阻塞队列
public interface BlockingQueue<E> {

    void offer(E value) throws InterruptedException;

    boolean offer(E value,long timeout) throws InterruptedException;

    E poll() throws InterruptedException;
}
