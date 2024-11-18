package com.tyut.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

import static com.tyut.util.Sleeper.sleep;

/**
 * @version v1.0
 * @author OldGj 2024/11/16
 * @apiNote 生产者消费者模式
 */
@Slf4j(topic = "c.ProducerConsumer")
public class ProducerConsumer {

    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue(2);
        for (int i = 0; i < 3; i++) {
            int id = i;
            sleep(1);
            // 模拟三个生产者
            new Thread(() -> {
                queue.put(new Message(id, "值" + id));
            }, "生产者" + i).start();
        }

        // 模拟一个消费者
        new Thread(() -> {
            while (true) {
                sleep(2);
                Message message = queue.take();
            }
        }, "消费者").start();
    }
}

/**
 * 消息队列
 */
@Slf4j(topic = "c.MessageQueue")
@SuppressWarnings("all")
class MessageQueue {
    // 消息队列集合
    private LinkedList<Message> queue;
    // 队列容量
    private int capacity;

    public MessageQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    // 存放消息
    public void put(Message message) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    log.debug("消息队列已经满了，生产者阻塞");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 将消息加入队列尾部
            queue.addLast(message);
            log.debug("生产者生产了一个消息：{}", message);
            queue.notifyAll(); // 唤醒消费者线程
        }
    }

    // 获取消息
    public Message take() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    log.debug("消息队列为空，消费者阻塞");
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = queue.removeFirst();
            log.debug("消费者已经消费了一个消息{}", message);
            queue.notifyAll(); // 唤醒生产者线程
            return message;
        }
    }
}

@SuppressWarnings("all")
class Message {
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
