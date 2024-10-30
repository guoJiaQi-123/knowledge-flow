package com.tyut.design.E02_factory.e2_factorymethod;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        // 订购美式咖啡
        CoffeeStore americanCoffeeStore = new CoffeeStore(new AmericanCoffeeFactory());
        Coffee americanCoffee = americanCoffeeStore.orderCoffee();
        System.out.println(americanCoffee.getName()); // 美式咖啡

        // 订购拿铁咖啡
        CoffeeStore latteCoffeeStore = new CoffeeStore(new LatteCoffeeFactory());
        Coffee latteCoffee = latteCoffeeStore.orderCoffee();
        System.out.println(latteCoffee.getName()); // 拿铁咖啡
    }
}
