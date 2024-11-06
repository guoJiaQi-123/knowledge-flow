package com.tyut.design.E10_combination;

/**
 * @version v1.0
 * @author OldGj 2024/11/6
 * @apiNote 文件类
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(name);
    }
}
