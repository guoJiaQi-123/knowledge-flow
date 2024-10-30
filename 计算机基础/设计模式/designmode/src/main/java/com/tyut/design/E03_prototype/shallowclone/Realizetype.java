package com.tyut.design.E03_prototype.shallowclone;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 浅克隆 - 具体的原型类 Java中的Object类中提供了 clone() 方法来实现浅克隆。
 */
public class Realizetype implements Cloneable {

    @Override
    protected Realizetype clone() throws CloneNotSupportedException {
        return (Realizetype) super.clone();
    }

}
