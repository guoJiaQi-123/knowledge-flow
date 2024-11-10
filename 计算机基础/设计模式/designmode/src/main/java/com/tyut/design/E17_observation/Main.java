package com.tyut.design.E17_observation;

public class Main {
    public static void main(String[] args) {
        SubscriptionSubject mSubscriptionSubject = new SubscriptionSubject();
        //创建微信用户
        WeixinUser user1 = new WeixinUser("孙悟空");
        WeixinUser user2 = new WeixinUser("猪悟能");
        WeixinUser user3 = new WeixinUser("沙悟净");
        //订阅公众号
        mSubscriptionSubject.attach(user1);
        mSubscriptionSubject.attach(user2);
        mSubscriptionSubject.attach(user3);
        //公众号更新发出消息给订阅的微信用户
        mSubscriptionSubject.notify("传智黑马的专栏更新了");
    }
}
