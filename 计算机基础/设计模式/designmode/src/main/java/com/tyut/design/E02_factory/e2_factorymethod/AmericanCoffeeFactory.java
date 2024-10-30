package com.tyut.design.E02_factory.e2_factorymethod;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 美式咖啡工厂-具体工厂
 */
public class AmericanCoffeeFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
}
