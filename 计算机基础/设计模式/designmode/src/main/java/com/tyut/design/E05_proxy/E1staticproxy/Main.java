package com.tyut.design.E05_proxy.E1staticproxy;

/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        // 通过代理商买票
        TrainStationProxyPoint proxyPoint = new TrainStationProxyPoint();
        proxyPoint.sell();
    }
}
