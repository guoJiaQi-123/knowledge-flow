package com.tyut.design.E02_factory.e4_configfactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author OldGj 2024/02/20
 * @version v1.0
 * @apiNote 简单咖啡工厂类 - 通过加载配置文件的方式，实现开闭原则，解除简单工厂类和具体产品类之间的耦合
 */
public class CoffeeFactory {

    //定义一个map容器存储对象
    private static final Map<String, Coffee> map = new HashMap<>();

    /*
     * 在静态代码块中加载配置文件并创建对象
     */
    static {
        InputStream resource = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource);
            //遍历Properties集合对象
            Set<Object> keySet = properties.keySet();
            for (Object key : keySet) {
                // 根据键获取值（全类名）
                String className = properties.getProperty((String) key);
                // 通过类的全限定路径创建类的反射（字节码）对象
                Class<?> clazz = Class.forName(className);
                // 通过反射对象调用类的无参构造实例化类
                Coffee coffee = (Coffee) clazz.newInstance();
                map.put((String) key, coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建咖啡对象「本质上是从map中根据键获取咖啡对象」
     * @param type
     * @return
     */
    public static Coffee createCoffee(String type) {
        return map.get(type);
    }

}
