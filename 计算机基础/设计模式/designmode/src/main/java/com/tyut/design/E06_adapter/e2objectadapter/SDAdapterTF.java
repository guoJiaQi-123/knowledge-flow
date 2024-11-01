package com.tyut.design.E06_adapter.e2objectadapter;

//定义适配器类（SD兼容TF）
public class SDAdapterTF implements SDCard {

    TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    public String readSD() {
        System.out.println("adapter read tf card ");
        return tfCard.readTF();
    }

    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}