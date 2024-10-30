package com.tyut.design.E02_factory.e3_absfactory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 具体工厂 - 美式风味甜点
 */
public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
