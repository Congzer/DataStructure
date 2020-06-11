package com.congzer.set.impl;

import com.congzer.linkdlist.LinkedList;
import com.congzer.set.Set;

/**
 * @Description 链表实现的集合
 * @Author zhangzhucong
 * @Date 2020/6/6
 **/
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedList;

    public LinkedListSet() {

        this.linkedList = new LinkedList<>();
    }

    //  增加O(1),但要先查O(n),故O(n)
    @Override
    public void add(E e) {

        if (!contains(e)) {

            // 链表对头操作时间复杂度是O(1)的
            linkedList.addFirst(e);
        }
    }

    // O(n)
    @Override
    public void remove(E e) {

        linkedList.removeElement(e);
    }

    // O(n)
    @Override
    public boolean contains(E e) {

        return linkedList.contains(e);
    }

    @Override
    public int getSize() {

        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {

        return linkedList.isEmpty();
    }
}