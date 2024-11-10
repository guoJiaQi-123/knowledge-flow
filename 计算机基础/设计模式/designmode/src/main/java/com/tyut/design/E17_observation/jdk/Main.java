package com.tyut.design.E17_observation.jdk;

public class Main {
    public static void main(String[] args) {
        //创建小偷对象 -》 主题
        Thief t = new Thief("隔壁老王");
        //创建警察对象 -》 观察者
        Policemen p = new Policemen("小李");
        //让警察盯着小偷 -》 添加观察者
        t.addObserver(p);
        //小偷偷东西
        t.steal();
    }
}