package com.tyut.design.E05_proxy.E2jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version v1.0
 * @author OldGj 2024/10/31
 * @apiNote 代理工厂
 */
public class ProxyFactory {

    private final Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        /**
         * 参数一：用于指定一个类加载器
         * 参数二：指定生成的代理长什么样子，也就是有哪些方法
         * 参数三：用来指定生成的代理对象要干什么事情
         */
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理商收费2元--代理工厂类");
                        return method.invoke(target, args);
                    }
                });
    }
}
