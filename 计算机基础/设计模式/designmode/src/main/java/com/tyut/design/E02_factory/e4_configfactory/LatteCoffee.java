package com.tyut.design.E02_factory.e4_configfactory;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 具体产品 - 拿铁咖啡
 */
public class LatteCoffee extends Coffee {
    @Override
    public String getName() {
        return "拿铁咖啡";
    }
}
