package com.tyut.design.E05_proxy.E1staticproxy;

/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote 车站
 */
public class TrainStation implements SellTickets {
    @Override
    public void sell() {
        System.out.println("车站买票5元");
    }
}
