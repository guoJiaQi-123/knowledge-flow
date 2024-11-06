package com.tyut.design.E11flyweight;

public abstract class AbstractBox {
    public abstract String getShape();

    // 设置外部数据color
    public void display(String color) {
        System.out.println("方块形状：" + this.getShape() + " 颜色：" + color);
    }
}