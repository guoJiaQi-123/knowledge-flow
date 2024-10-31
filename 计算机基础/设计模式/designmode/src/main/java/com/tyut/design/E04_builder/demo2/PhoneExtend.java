package com.tyut.design.E04_builder.demo2;


/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote 手机类-使用建造者模式扩展
 */
public class PhoneExtend {
    private String cpu; // CPU
    private String screen;// 屏幕
    private String memory; // 外存
    private String mainboard; // 主存

    private PhoneExtend(Builder builder) {
        this.cpu = builder.cpu;
        this.screen = builder.screen;
        this.memory = builder.memory;
        this.mainboard = builder.mainboard;
    }

    static class Builder {
        private String cpu; // CPU
        private String screen;// 屏幕
        private String memory; // 外存
        private String mainboard; // 主存

        public Builder cpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder screen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder memory(String memory) {
            this.memory = memory;
            return this;
        }

        public Builder mainboard(String mainboard) {
            this.mainboard = mainboard;
            return this;
        }

        public PhoneExtend build() {
            return new PhoneExtend(this);
        }

    }

    @Override
    public String toString() {
        return "PhoneExtend{" +
                "cpu='" + cpu + '\'' +
                ", screen='" + screen + '\'' +
                ", memory='" + memory + '\'' +
                ", mainboard='" + mainboard + '\'' +
                '}';
    }
}
