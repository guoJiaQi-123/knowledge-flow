package com.tyut.design.E09facade;

/**
 * @version v1.0
 * @author OldGj 2024/11/2
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        //创建外观对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        //客户端直接与外观对象进行交互
        facade.say("打开");
        System.out.println("---------------------");
        facade.say("关闭");
    }
}
