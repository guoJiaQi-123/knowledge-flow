package com.tyut.list;

import java.util.ArrayList;

/**
 * @version v1.0
 * @author OldGj 2024/11/10
 * @apiNote ArrayList实例
 */
public class MainArrayList {
    public static void main(String[] args) {
        //创建一个ArrayList来存储商品
        ArrayList<String> products = new ArrayList<>();

        //添加商品到ArrayList
        products.add("苹果");
        products.add("香蕉");
        products.add("橙子");

        //输出商品列表
        System.out.println("商品列表：");
        for (String product : products) {
            System.out.println(product);
        }

        //获取第二个商品（索引为1，因为索引I从0开始）
        String secondProduct = products.get(1);
        System.out.println("第二个商品是:" + secondProduct);

        //修改第二个商品的名字
        products.set(1, "梨子");
        System.out.println("修改后的商品列表：");
        for (String product : products) {
            System.out.println(product);
        }

        //检查是否包含某个商品
        boolean containsOrange = products.contains("橙子");
        System.out.println("商品列表是否包含橙子：" + containsOrange);

        //删除最后一个商品
        products.remove(products.size() - 1);
        System.out.println("删除最后一个商品后的商品列表：");
        for (String product : products) {
            System.out.println(product);
        }

    }
}
