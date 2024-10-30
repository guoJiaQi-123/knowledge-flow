package com.tyut.design.E02_factory.e3_absfactory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 具体工厂 - 意大利风味甜点
 */
public class ItalyDessertFactory implements DessertFactory {
    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
