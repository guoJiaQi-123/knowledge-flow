package com.dataStructure.dataStructure.stack;

import java.util.Iterator;

public class ArrayStack<E> implements Stack<E>, Iterable<E> {
    private final E[] stack;
    private int top;

    @SuppressWarnings("ALL")
    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        stack[top++] = value;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        return stack[--top];
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return stack[top-1];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == stack.length;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = top;
            @Override
            public boolean hasNext() {
                return p>0;
            }

            @Override
            public E next() {
                return stack[--p];
            }
        };
    }
}
