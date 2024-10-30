package com.tyut.design.E04_builder.demo1;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 抽象建造者类
 */
public abstract class Builder {
    // 组合bike类
    protected Bike bike = new Bike();

    // 抽象建造车身
    public abstract void buildFrame();

    // 抽象建造车座
    public abstract void buildSeat();

    // 抽象构建自行车
    public abstract Bike creatBike();

}
