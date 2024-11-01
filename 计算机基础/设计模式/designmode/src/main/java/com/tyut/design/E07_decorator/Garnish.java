package com.tyut.design.E07_decorator;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote 抽象装饰（Decorator）角色
 */
public abstract class Garnish extends FastFood {

    // 被装饰的对象
    private FastFood fastFood;

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }
}
