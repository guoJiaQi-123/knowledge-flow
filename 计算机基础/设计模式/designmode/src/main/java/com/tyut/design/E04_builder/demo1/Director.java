package com.tyut.design.E04_builder.demo1;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 指挥者类
 */
public class Director {

    // 依赖建造者类，需要使用建造者类的构建方法
    private Builder builder;

    // 传入什么类型的建造者，最后建造的就是什么类型的自行车
    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 建造自行车
     * @return
     */
    public Bike construct() {
        builder.buildFrame(); // 构建车身
        builder.buildSeat(); // 构建车座
        return builder.creatBike(); // 返回构建的自行车
    }
}
