package com.tyut.design.E12_template;

/**
 * @version v1.0
 * @author OldGj 2024/11/8
 * @apiNote Main方法
 */
public class Main {
    public static void main(String[] args) {
        //炒手撕包菜
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();

        //炒蒜蓉菜心
        ConcreteClass_CaiXin caiXin = new ConcreteClass_CaiXin();
        caiXin.cookProcess();
    }
}
