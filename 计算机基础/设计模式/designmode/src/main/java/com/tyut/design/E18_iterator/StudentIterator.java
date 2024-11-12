package com.tyut.design.E18_iterator;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote 抽象迭代器
 */
public interface StudentIterator {

    // 是否存在下一个元素
    boolean hasNext();

    // 返回当前元素
    Student next();

}
