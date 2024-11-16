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
            // 模拟三个生产者
            new Thread(() -> {
                queue.put(new Message(id, "值" + id));
            }, "生产者" + i).start();
        }

        new Thread(() -> {
            while (true) {
                sleep(1);
                Message message = queue.take();
            }
        }, "消费者").start();
    }
}

@Slf4j(topic = "c.MessageQueue")
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
            queue.notifyAll();
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
            queue.notifyAll();
            return message;
        }
    }
}

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
