package com.tyut.design.E14_command;


import java.util.Set;

/**
 * 具体命令类
 */
@SuppressWarnings("all")
public class OrderCommand implements Command {

    //持有接受者对象 -> 命令谁
    private SeniorChef receiver;
    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单：");
        Set<String> keys = order.getFoodDic().keySet();
        for (String key : keys) {
            receiver.makeFood(order.getFoodDic().get(key), key);
        }
        try {
            Thread.sleep(1000);//停顿一下 模拟做饭的过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(order.getDiningTable() + "桌的饭弄好了");
    }
}