package com.dataStructure.dataStructure.stack;

import java.util.LinkedList;

/**
 * 中缀表达式转后缀
 */
public class E03InfixToSuffix {

    public static void test() {
        int a = 10;
        int b = 20;
        int c = 5;
        int d = (a + b) * c;
    }

    /*
        思路

        |   |
        |   |
        |   |
        _____

        a+b             ab+
        a+b-c           ab+c-
        a*b+c           ab*c+
        a+b*c           abc*+
        a+b*c-d         abc*+d-
        (a+b)*c         ab+c*
        (a+b*c-d)*e     abc*+d-e*
        a*(b+c)         abc+*

        1. 遇到非运算符 直接拼串
        2. 遇到 + - * /
            - 它的优先级比栈顶运算符高, 入栈, 如: 栈中是 + 当前是 *
            - 否则把栈里优先级 >= 它 的都出栈, 它再入栈, 如: 栈中是 +*, 当前是 -
        3. 遍历完成, 栈里剩余运算符依次出栈
        4. 带()
            - 左括号直接入栈, 左括号优先设置为0
            - 右括号就把栈里到左括号为止的所有运算符出栈
     */
    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b)*c"));
        System.out.println(infixToSuffix("(a+b*c-d)*e"));
        System.out.println(infixToSuffix("a*(b+c)"));
    }


    //计算优先级
    static int priority(char c) {
        return switch (c) {
            case '+', '-' -> 1; // + - 优先级为 1
            case '*', '/' -> 2; // * / 优先级为 2
            case '(' -> 0;
            default -> throw new IllegalArgumentException("输入的参数不合法 " + c);
        };
    }

    static String infixToSuffix(String exp) {
        //定义一个StringBuilder字符串变量，用于拼接结果集字符串
        StringBuilder result = new StringBuilder(exp.length());
        //定义一个栈，用于存放按照规定的优先级规律存放 运算符
        LinkedList<Character> stack = new LinkedList<>();
        //遍历字符串参数（中缀表达式）
        for (int i = 0; i < exp.length(); i++) {
            //取到表达式中的每一个字符
            char c = exp.charAt(i);
            //如果取到的字符为运算符或者括号，则根据规则入栈或者出栈，如果取到的字符是非运算符和括号，则直接参与字符串拼接
            switch (c) {
                case '+', '-', '*', '/' -> {
                    //如果栈是空的，则直接将字符串压入栈中
                    if (stack.isEmpty()) {
                        stack.push(c);
                    } else {
                        //如果栈非空，则判断当前运算符的优先级及栈顶运算符优先级，如果当前运算符优先级高于栈顶运算符优先级，则将当前运算符压人栈
                        if (priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        } else {//如果当前运算符优先级小于或等于栈顶运算符优先级，则将栈顶运算符弹栈后拼接到结果集字符串中，并循环比较，如果栈被弹空，停止循环
                            while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                                result.append(stack.pop());
                            }
                            //最后将当前运算符压入栈中
                            stack.push(c);
                        }
                    }
                }//如果当前字符为左括号，则直接压入栈中
                case '(' -> {
                    stack.push('(');
                }//如果当前运算符是右括号，则将栈中左括号上面的所有运算符弹栈后拼接到结果集字符串中
                case ')' -> {
                    while (!stack.isEmpty()&& stack.peek()!='('){
                        result.append(stack.pop());
                    }
                    //最后将左括号从栈中弹出
                    stack.pop();
                }
                //字符为非运算符，直接拼接到结果集字符串中
                default -> result.append(c);
            }
        }
        //当字符串中每个字符都被迭代后，将栈中还未弹栈的运算符弹出并拼接到结果集字符串中
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        //返回StringBuilder的toString字符串类型
        return result.toString();
    }
}
