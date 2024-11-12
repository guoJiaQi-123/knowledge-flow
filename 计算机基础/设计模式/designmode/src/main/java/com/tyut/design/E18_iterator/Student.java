package com.tyut.design.E18_iterator;

/**
 * @version v1.0
 * @author OldGj 2024/11/12
 * @apiNote Student类
 */
public class Student {
    private String name;
    private String num;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String name, String num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
