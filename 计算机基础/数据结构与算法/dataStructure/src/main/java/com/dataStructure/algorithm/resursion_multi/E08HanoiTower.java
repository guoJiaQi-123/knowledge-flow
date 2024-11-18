package com.dataStructure.algorithm.resursion_multi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 汉诺塔
 */
public class E08HanoiTower {
    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();

    /**
     *
     * @param n 圆盘个数
     * @param a 圆盘原来所在的柱子
     * @param b 圆盘移动需要借助的柱子
     * @param c 圆盘目标所要到达的柱子
     */
    public static void move(int n,LinkedList<Integer> a,LinkedList<Integer> b,LinkedList<Integer> c){

        if(n==0){
            return;
        }
        move(n-1,a,c,b);
        c.addLast(a.removeLast());
        print();
        move(n-1,b,a,c);
    }


    public static void main(String[] args) {
        init(3);
        print();

        move(3,a,b,c);

    }





    //初始化方法
    private static void init(int n) {
        for(int i=n;i>=1;i--){
            a.addLast(i);
        }
    }


    //输出方法
    private static void print() {
        System.out.println("-----------");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
