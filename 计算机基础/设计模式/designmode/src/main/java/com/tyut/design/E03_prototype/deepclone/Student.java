package com.tyut.design.E03_prototype.deepclone;

import java.io.Serializable;

/**
 * @version v1.0
 * @author OldGj 2024/10/30
 * @apiNote 学生类
 */
public class Student implements Serializable {

    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
