package com.congzer.queue.impl;

import com.congzer.array.Array;
import com.congzer.queue.Queue;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/14
 **/
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue() {

        array = new Array<>();
    }

    public ArrayQueue(int capacity) {

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

    //均摊 O(n)
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    //O(n) 出队时第一个元素出去，后面的元素都要向前移动位置，可通过循环队列来优化为O(1)
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < getSize(); i++) {

            res.append(array.get(i));
            if (i != getSize() - 1) {

                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
