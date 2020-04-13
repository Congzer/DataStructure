package com.congzer.stack;

import com.congzer.array.Array;

public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

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

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        try {

            return array.removeLast();
        } catch (IllegalArgumentException e) {

            return null;
        }
    }

    @Override
    public E peek() {
        try {

            return array.getLast();
        } catch (IllegalArgumentException e) {

            return null;
        }
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
