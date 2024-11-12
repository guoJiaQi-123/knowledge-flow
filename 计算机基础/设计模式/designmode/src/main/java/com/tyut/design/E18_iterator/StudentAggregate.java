package com.tyut.design.E18_iterator;

/**
 * @version v1.0
 * @apiNote 抽象聚合对象
 * @author OldGj 2024/11/12
 */
public interface StudentAggregate {

    // 添加学生对象
    void addStudent(Student student);
    // 删除学生对象
    void removeStudent(Student student);
    // 获取迭代器对象
    StudentIterator getStudentIterator();

}
