package com.tyut.design.E05_proxy.E1staticproxy;

/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote 车站代理商
 */
public class TrainStationProxyPoint implements SellTickets {

    // 组合被代理类
    private final TrainStation trainStation = new TrainStation();

    // 代理方法
    @Override
    public void sell() {
        System.out.println("代理商收取2元代理费"); // 对原有方法进行增强
        trainStation.sell(); // 执行原有方法
    }
}
