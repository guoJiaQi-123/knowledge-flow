package com.tyut.design.E07_decorator;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote 鸡蛋类 具体装饰（ConcreteDecorator）角色
 */
public class Egg extends Garnish {

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    @Override
    public float cost() {
        // 自己的价格 + 被装饰的价格
        return getPrice() + getFastFood().getPrice();
    }

    @Override
    public String getDesc() {
        // 自己的描述 + 被装饰的描述
        return super.getDesc() + getFastFood().getDesc();
    }
}
