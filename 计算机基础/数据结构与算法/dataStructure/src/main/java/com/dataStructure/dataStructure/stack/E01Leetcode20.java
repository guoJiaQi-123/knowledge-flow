package com.dataStructure.dataStructure.stack;

import java.util.*;
import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class E01Leetcode20 {
    public boolean isValid(String s) {
        // 创建一个栈
        Stack<Character> stack = new Stack<>();
        // 遍历字符串中的每一个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果字符是左括号，则将右括号压入栈中
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                // 如果字符是右括号，则判断栈中是否有对应的左括号
                if (!stack.isEmpty() && c == stack.peek()) {
                    stack.pop();
                } else {
                    // 如果没有对应的左括号，则返回false
                    return false;
                }
            }
        }
        // 如果栈为空，则返回true
        return stack.isEmpty();
    }
}
