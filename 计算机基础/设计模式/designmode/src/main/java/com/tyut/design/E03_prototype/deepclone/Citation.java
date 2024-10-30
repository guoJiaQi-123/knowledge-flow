package com.tyut.design.E03_prototype.deepclone;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

//奖状类
public class Citation implements Cloneable, Serializable {
    private Student student; // 引用数据类型

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void show() {
        System.out.println(student.getName() + "同学：在2020学年第一学期中表现优秀，被评为三好学生。特发此状！");
    }

    /**
     * 深克隆-使用序列化实现 需要对象实现Serializable接口
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Citation clone() throws CloneNotSupportedException {
        try {
            // 对象输出流-序列化
            ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("d://clone.txt")));
            // 将对象写入磁盘
            outputStream.writeObject(this);
            outputStream.close();

            // 对象输入流-反序列化
            ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get("d://clone.txt")));
            // 将对象从磁盘写入
            Citation cloneCitation = (Citation) inputStream.readObject();
            inputStream.close();
            return cloneCitation;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}