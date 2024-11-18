package com.dataStructure.algorithm.resursion_multi;


import java.util.Arrays;

/**
 * 递归求斐波那契第 N 项 <多路递归>
 */
public class E06Fibonacci {

    /**
     * 使用Memoization(记忆法，也称备忘录)改进
     * @param n 第n项
     * @return 第n项的值
     */
    public static int fibonacci(int n){
        int[] cache = new int[n+1];
        Arrays.fill(cache,-1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n,cache);
    }

    public static int f(int n,int[] cache){

        if(cache[n]!=-1){
            return cache[n];
        }

        cache[n] = f(n-1,cache)+f(n-2,cache);
        return cache[n];
    }
}
