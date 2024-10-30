package com.tyut.design.E02_factory.e3_absfactory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 抽象产品 - 咖啡
 */
public abstract class Coffee {
    public abstract String getName();

    public void addSugar() {
        System.out.println("加糖");
    }

    public void addMilk() {
        System.out.println("加奶");
    }
}




