package com.tyut.design.E02_factory.e2_factorymethod;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 咖啡类
 */
public class Coffee {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMilk() {
        System.out.println("添加牛奶");
    }

    public void addSugar() {
        System.out.println("添加糖");
    }
}
