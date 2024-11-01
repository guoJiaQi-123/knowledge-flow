package com.tyut.design.E07_decorator;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote 具体构件（Concrete  Component）角色 - 炒面类
 */
public class FriedNoodles extends FastFood {

    public FriedNoodles() {
        super(12, "炒面");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
