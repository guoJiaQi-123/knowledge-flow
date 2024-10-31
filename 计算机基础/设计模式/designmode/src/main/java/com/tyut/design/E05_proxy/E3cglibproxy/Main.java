package com.tyut.design.E05_proxy.E3cglibproxy;


import net.sf.cglib.proxy.Enhancer;

/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new TrainStation());
        TrainStation proxy = (TrainStation) proxyFactory.createProxy();
        proxy.sell();
    }
}
