package com.tyut.design.E02_factory.e1_simplefactory;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee.getName());

        Coffee american = coffeeStore.orderCoffee("american");
        System.out.println(american.getName());
    }
}
