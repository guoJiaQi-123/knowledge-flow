package com.tyut.design.E06_adapter.e2objectadapter;

//SD卡的接口
public interface SDCard {
    //读取SD卡方法
    String readSD();
    //写入SD卡功能
    void writeSD(String msg);
}