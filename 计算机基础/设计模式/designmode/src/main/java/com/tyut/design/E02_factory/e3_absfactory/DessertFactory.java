package com.tyut.design.E02_factory.e3_absfactory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 抽象工厂  -  甜点接口
 */
public interface DessertFactory {
    Dessert createDessert();

    Coffee createCoffee();
}
