package com.tyut.design.E05_proxy.E2jdkdynamicproxy;


/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        // 代理工具类对象获取代理对象
        SellTickets proxy1 = (SellTickets) ProxyUtils.createProxy(new TrainStation());
        proxy1.sell();

        // 代理工厂类对象获取代理对象
        ProxyFactory proxyFactory = new ProxyFactory(new TrainStation());
        SellTickets proxy2 = (SellTickets) proxyFactory.createProxy();
        proxy2.sell();
    }
}
