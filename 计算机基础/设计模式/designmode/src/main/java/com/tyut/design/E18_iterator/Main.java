package com.tyut.design.E18_iterator;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote main方法
 */
public class Main {
    public static void main(String[] args) {
        StudentAggregate studentAggregate = new StudentAggregateImpl();
        studentAggregate.addStudent(new Student("孙悟空","001"));
        studentAggregate.addStudent(new Student("猪悟能","002"));
        studentAggregate.addStudent(new Student("沙悟净","003"));
        StudentIterator studentIterator = studentAggregate.getStudentIterator();
        while (studentIterator.hasNext()) {
            Student next = studentIterator.next();
            System.out.println(next);
        }
    }
}
