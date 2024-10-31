package com.tyut.design.E04_builder.demo2;

/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        // 建造者模式扩展前
        Phone phone = new Phone("intel", "huawei", "长江存储", "8G");
        System.out.println(phone);

        // 建造者模式扩展后
        PhoneExtend phoneExtend = new PhoneExtend.Builder()
                .cpu("intel")
                .screen("huawei")
                .memory("长江存储")
                .mainboard("16G")
                .build();
        System.out.println(phoneExtend);
    }
}
