package com.tyut.design.E10_combination;

/**
 * @version v1.0
 * @author OldGj 2024/11/6
 * @apiNote 抽象根节点
 */
public abstract class MenuComponent {

    protected String name;
    protected int level;

    /**
     * 添加子节点
     * @param menuComponent
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 移除子节点
     * @param menuComponent
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取子节点
     * @param i
     * @return
     */
    public MenuComponent getChile(int i) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取名称
     * @return
     */
    public String getName() {
        return this.name;
    }

    public abstract void print();

}
