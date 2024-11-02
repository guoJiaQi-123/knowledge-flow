package com.tyut.design.E09facade;

/**
 * @version v1.0
 * @author OldGj 2024/11/2
 * @apiNote 智能音箱类
 */
public class SmartAppliancesFacade {

    private final Light light;
    private final TV tv;
    private final AirCondition airCondition;

    public SmartAppliancesFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    /**
     * 语音控制
     * @param message
     */
    public void say(String message) {
        if (message.contains("打开")) {
            on();
        } else if (message.contains("关闭")) {
            off();
        } else {
            System.out.println("我还听不懂你说的！！！");
        }
    }

    //起床后一键开电器
    private void on() {
        System.out.println("起床了");
        light.on();
        tv.on();
        airCondition.on();
    }

    //睡觉一键关电器
    private void off() {
        System.out.println("睡觉了");
        light.off();
        tv.off();
        airCondition.off();
    }
}
