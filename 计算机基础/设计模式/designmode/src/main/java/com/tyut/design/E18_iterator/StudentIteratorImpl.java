package com.tyut.design.E18_iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote 具体迭代器对象
 */
public class StudentIteratorImpl implements StudentIterator {

    private List<Student> studentList;

    private int position;

    public StudentIteratorImpl(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return position < studentList.size();
    }

    @Override
    public Student next() {
        Student student = studentList.get(position);
        position++;
        return student;
    }
}
