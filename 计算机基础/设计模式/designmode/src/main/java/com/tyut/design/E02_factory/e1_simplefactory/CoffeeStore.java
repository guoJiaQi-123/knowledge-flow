package com.tyut.design.E02_factory.e1_simplefactory;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 咖啡商店
 */
public class CoffeeStore {


    /**
     * 订购咖啡
     * @param type
     * @return
     */
    public Coffee orderCoffee(String type) {
        // 用咖啡工厂创建咖啡
        CoffeeSimpleFactory factory = new CoffeeSimpleFactory();
        return factory.createCoffee(type);
    }
}
