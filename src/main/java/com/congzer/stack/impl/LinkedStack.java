package com.congzer.stack.impl;

import com.congzer.linkdlist.LinkedList;
import com.congzer.stack.Stack;

/**
 * @Description 链表实现的栈数据结构
 * @Author zhangzhucong
 * @Date 2020/4/20
 **/
public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    //O(1)
    @Override
    public void push(E e) {

        list.addFirst(e);
    }

    //O(1)
    @Override
    public E pop() {
        return list.removeFirst();
    }

    //O(1)
    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Stack: top  ");
        res.append(list);
        return res.toString();
    }
}
