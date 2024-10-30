package com.tyut.design.E02_factory.e3_absfactory;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote main主方法
 */
public class Main {
    public static void main(String[] args) {
        // 意大利风味甜品
        ItalyDessertFactory italyDessertFactory = new ItalyDessertFactory();
        Dessert dessert = italyDessertFactory.createDessert();
        System.out.println(dessert.getName()); // 提拉米苏
        Coffee coffee = italyDessertFactory.createCoffee();
        System.out.println(coffee.getName()); // 拿铁咖啡

        // 美式风味甜品
        AmericanDessertFactory americanDessertFactory = new AmericanDessertFactory();
        Dessert dessert1 = americanDessertFactory.createDessert();
        System.out.println(dessert1.getName()); // 抹茶慕斯
        Coffee coffee1 = americanDessertFactory.createCoffee();
        System.out.println(coffee1.getName()); // 美式咖啡
    }
}
