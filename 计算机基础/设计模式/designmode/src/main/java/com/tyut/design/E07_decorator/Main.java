package com.tyut.design.E07_decorator;

/**
 * @version v1.0
 * @author OldGj 2024/11/1
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        // 炒面
        FriedNoodles friedNoodles = new FriedNoodles();
        // 给炒面加个鸡蛋装饰者
        Egg egg = new Egg(friedNoodles);
        System.out.println(egg.getDesc() + egg.cost());

        // 炒饭
        FriedRice friedRice = new FriedRice();
        // 给炒饭加个培根装饰者
        Bacon bacon = new Bacon(friedRice);
        System.out.println(bacon.getDesc() + bacon.cost());
    }
}
