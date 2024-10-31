package com.tyut.design.E06adapter.e2objectadapter;

//测试类
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        SDCard sdCard = new SDCardImpl();
        System.out.println(computer.readSD(sdCard));

        System.out.println("------------");

        SDAdapterTF adapter = new SDAdapterTF(new TFCardImpl());
        System.out.println(computer.readSD(adapter));
    }
}