package com.tyut.design.E11flyweight;

/**
 * @version v1.0
 * @author OldGj 2024/11/6
 * @apiNote Main方法
 */
public class Main {
    public static void main(String[] args) {
        AbstractBox I = BoxFactory.getInstance().getShape("I");
        AbstractBox L = BoxFactory.getInstance().getShape("L");
        AbstractBox O = BoxFactory.getInstance().getShape("O");
        I.display("蓝色");
        L.display("绿色");
        O.display("红色");
        AbstractBox O2 = BoxFactory.getInstance().getShape("O");
        O2.display("紫色");
        System.out.println("O和O2是否相同：" + (O == O2));
    }
}
