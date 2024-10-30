package com.tyut.design.E02_factory.e3_absfactory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 具体产品 - 美式咖啡
 */
public class AmericanCoffee extends Coffee {
    @Override
    public String getName() {
        return "美式咖啡";
    }
}
