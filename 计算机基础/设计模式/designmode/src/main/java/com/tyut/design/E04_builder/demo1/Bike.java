package com.tyut.design.E04_builder.demo1;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 单车类
 */
public class Bike {
    private String frame;
    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void show() {
        System.out.println("我的车身是：" + frame + "   我的车座是：" + seat);
    }
}
