package com.dataStructure.algorithm.recursion_single;

/**
 * 递归反向打印字符串
 */
public class E02ReversePrintString {

    public static void f(int n,String string){
        if(n==string.length()){
            return;
        }
        f(n+1,string);
        System.out.println(string.charAt(n));
    }

    public static void main(String[] args) {
        E02ReversePrintString.f(0,"abcdef");
    }
}
