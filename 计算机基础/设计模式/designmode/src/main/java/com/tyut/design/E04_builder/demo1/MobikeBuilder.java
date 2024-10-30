package com.tyut.design.E04_builder.demo1;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 摩拜单车建造者
 */
public class MobikeBuilder extends Builder {

    @Override
    public void buildFrame() {
        bike.setFrame("摩拜车身");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("摩拜车座");
    }

    @Override
    public Bike creatBike() {
        return bike;
    }
}
