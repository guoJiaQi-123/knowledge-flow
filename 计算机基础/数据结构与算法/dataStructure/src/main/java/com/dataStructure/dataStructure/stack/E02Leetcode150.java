package com.dataStructure.dataStructure.stack;

import java.util.LinkedList;

public class E02Leetcode150 {
    //jdk新语法，不需要写break
    public int evalRPN(String[] tokens) {
        //定义一个栈数据结构
        LinkedList<Integer> stack = new LinkedList<>();
        //迭代字符串数组中的每一个元素
        for (String s : tokens) {
            switch (s) {
                //如果当前字符为" + "，则将栈顶两个元素弹出，做和运算后再压入栈中
                case "+" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                }
                //如果当前字符串为" - "，则将栈顶两个元素弹出，做差运算后再压入栈中（注意弹栈顺序：先弹栈的做减数）
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                //如果当前字符串为" * "，则将栈顶两个元素弹出，做乘积运算后再压入栈中
                case "*" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                }
                //如果当前字符串为" / "，则将栈顶两个元素弹出，做除法运算后再压入栈中（注意弹栈顺序：先弹栈的做除数）
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                //如果当前字符串为非运算符，则转为int类型后，压入栈中
                default -> {
                    stack.push(Integer.parseInt(s));
                }
            }
        }
        //最后将栈中最后一个也是唯一一个元素返回，即是后缀表达式运算结果
        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {
        //jdk旧语法
        LinkedList<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            switch (s) {
                case "+": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default: {
                    stack.push(Integer.parseInt(s));
                }
            }
        }
        return stack.pop();
    }
}
