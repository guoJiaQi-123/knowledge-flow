package com.tyut.design.E04_builder.demo1;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        // 传入摩拜单车建造者，建造摩拜单车
        Director director = new Director(new MobikeBuilder());
        Bike mobike = director.construct();
        mobike.show();

        // 传入共享单车建造者，构建共享单车
        Director director1 = new Director(new OfoBikeBuilder());
        Bike ofobike = director1.construct();
        ofobike.show();
    }
}
