package com.tyut.design.E07_decorator;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote 具体构件（Concrete  Component）角色 - 炒饭类
 */
public class FriedRice extends FastFood {

    public FriedRice() {
        super(10, "炒饭");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
