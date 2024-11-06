package com.tyut.design.E10_combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/11/6
 * @apiNote 文件夹
 */
public class Menu extends MenuComponent {

    private final List<MenuComponent> menuComponentList;

    public Menu(String name, int level) {
        this.level = level;
        this.name = name;
        menuComponentList = new ArrayList<MenuComponent>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChile(int i) {
        return menuComponentList.get(i);
    }


    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        System.out.println(name);
        for (MenuComponent menuComponent : menuComponentList) {
            menuComponent.print();
        }
    }
}
