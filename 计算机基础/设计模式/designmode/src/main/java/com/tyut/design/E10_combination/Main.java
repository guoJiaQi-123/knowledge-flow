package com.tyut.design.E10_combination;

/**
 * @version v1.0
 * @author OldGj 2024/11/6
 * @apiNote Main主方法
 */
public class Main {
    public static void main(String[] args) {
        MenuComponent menu1 = new Menu("菜单管理", 2);
        menu1.add(new MenuItem("页面访问", 3));
        menu1.add(new MenuItem("展开菜单", 3));
        menu1.add(new MenuItem("编辑菜单", 3));
        menu1.add(new MenuItem("删除菜单", 3));
        menu1.add(new MenuItem("新增菜单", 3));

        MenuComponent menu2 = new Menu("权限管理", 2);
        menu2.add(new MenuItem("页面访问", 3));
        menu2.add(new MenuItem("提交保存", 3));

        MenuComponent menu3 = new Menu("角色管理", 2);
        menu3.add(new MenuItem("页面访问", 3));
        menu3.add(new MenuItem("新增角色", 3));
        menu3.add(new MenuItem("修改角色", 3));

        MenuComponent menu = new Menu("系统管理", 1);
        menu.add(menu1);
        menu.add(menu2);
        menu.add(menu3);

        menu.print();
    }
}
