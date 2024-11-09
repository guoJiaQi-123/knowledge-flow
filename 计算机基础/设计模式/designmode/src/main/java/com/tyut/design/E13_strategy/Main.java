package com.tyut.design.E13_strategy;

/**
 * @version v1.0
 * @author OldGj 2024/11/9
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        // 买一送一
        SalesMan salesManA = new SalesMan(new StrategyA());
        salesManA.salesManShow();

        // 满200元减50元
        SalesMan salesManB = new SalesMan(new StrategyB());
        salesManB.salesManShow();

        // 满1000元加一元换购任意200元以下商品
        SalesMan salesManC = new SalesMan(new StrategyC());
        salesManC.salesManShow();
    }
}
