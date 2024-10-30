package com.tyut.design.E02_factory.e4_configfactory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 测试类 - 客户端
 */
public class Main {
    public static void main(String[] args) {
        Coffee americanCoffee = CoffeeFactory.createCoffee("american");
        System.out.println(americanCoffee.getName());// 美式咖啡

        Coffee latteCoffee = CoffeeFactory.createCoffee("latte");
        System.out.println(latteCoffee.getName()); // 拿铁咖啡

        Coffee kuCoffee = CoffeeFactory.createCoffee("ku");
        System.out.println(kuCoffee.getName());// 苦咖啡
    }
}
