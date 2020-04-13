package com.congzer.stack;

public interface Stack<E> {

    //O(1)
    int getSize();

    //O(1)
    boolean isEmpty();

    //O(1)
    void push(E e);

    //O(1)
    E pop();

    //O(1)
    E peek();
}