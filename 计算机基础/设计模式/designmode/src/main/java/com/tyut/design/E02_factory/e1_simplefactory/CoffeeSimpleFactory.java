package com.tyut.design.E02_factory.e1_simplefactory;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 咖啡简单工厂
 */
public class CoffeeSimpleFactory {

    /**
     * 咖啡工厂用来创建咖啡
     * @param type
     * @return
     */
    public Coffee createCoffee(String type) {
        if ("american".equals(type)) {
            return new AmericanCoffee();
        } else if ("latte".equals(type)) {
            return new LatteCoffee();
        } else {
            throw new RuntimeException("没有这种咖啡");
        }
    }

}
