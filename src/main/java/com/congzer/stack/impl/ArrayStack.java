package com.congzer.stack.impl;

import com.congzer.array.Array;
import com.congzer.stack.Stack;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {

        array = new Array<>();
    }

    public ArrayStack(int capacity) {

        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    //均摊O(1)
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    //均摊O(1)
    @Override
    public E pop() {
        return array.removeLast();
    }

    //O(1)
    @Override
    public E peek() {
        return array.getLast();
    }

    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < getSize(); i++) {

            res.append(array.get(i));
            if (i != getSize() - 1) {

                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }
}
