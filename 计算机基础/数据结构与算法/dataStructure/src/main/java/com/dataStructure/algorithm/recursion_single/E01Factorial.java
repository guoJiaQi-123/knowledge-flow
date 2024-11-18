package com.dataStructure.algorithm.recursion_single;

/**
 * 递归算法实现阶乘
 */
public class E01Factorial {

    public static int f(int i){
        if(i==1){
            return 1;
        }
        return i*f(i-1);
    }

    public static void main(String[] args) {
        int f = E01Factorial.f(5);
        System.out.println(f);
    }
}
