package com.tyut.design.E04_builder.demo1;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 共享单车建造者
 */
public class OfoBikeBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("共享车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("共享车座");
    }

    @Override
    public Bike creatBike() {
        return bike;
    }
}
