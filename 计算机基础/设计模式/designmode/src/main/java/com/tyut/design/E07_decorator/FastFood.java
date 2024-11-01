package com.tyut.design.E07_decorator;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote 抽象构件（Component）角色 - 抽象快餐类
 */
public abstract class FastFood {

    private float price;

    private String desc;

    public FastFood() {
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public abstract float cost();

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
