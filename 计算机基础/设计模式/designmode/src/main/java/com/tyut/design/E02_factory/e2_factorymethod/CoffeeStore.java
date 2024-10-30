package com.tyut.design.E02_factory.e2_factorymethod;

import com.tyut.design.E02_factory.e1_simplefactory.CoffeeSimpleFactory;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 咖啡商店
 */
public class CoffeeStore {
    private final CoffeeFactory coffeeFactory;

    /**
     * 在构造咖啡商店时，传入什么咖啡工厂，则订购的是什么咖啡
     */
    public CoffeeStore(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    /**
     * 订购咖啡
     * @return
     */
    public Coffee orderCoffee() {
        // 用咖啡工厂创建咖啡
        return coffeeFactory.createCoffee();
    }
}
