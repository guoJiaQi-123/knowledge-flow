package com.tyut.design.E17_observation;

import java.util.ArrayList;
import java.util.List;

// 具体主题 - 微信公众号
public class SubscriptionSubject implements Subject {
    //储存订阅公众号的微信用户
    private final List<Observer> weixinUserlist = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weixinUserlist.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserlist.remove(observer);
    }

    @Override
    public void notify(String message) {
        // 遍历每个用户，调用他的update方法通知
        for (Observer observer : weixinUserlist) {
            observer.update(message);
        }
    }
}