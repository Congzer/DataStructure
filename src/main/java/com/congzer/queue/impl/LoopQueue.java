package com.congzer.queue.impl;

import com.congzer.queue.Queue;

/**
 * @Description 循环队列
 * @Author zhangzhucong
 * @Date 2020/4/14
 **/
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    private int front, tail;

    private int size;

    public LoopQueue(int capacity) {

        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {

        this(10);
    }

    public int getCapacity() {

        return data.length - 1;
    }

    @Override
    public int getSize() {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return front == tail;
    }

    //均摊 O(1)
    @Override
    public void enqueue(E e) {

        if ((tail + 1)% data.length == front) {

            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {

            newData[i] = data[(front + i) % data.length] ;
        }
        data = newData;
        front = 0;
        tail = size;
    }

    //均摊 O(1)
    @Override
    public E dequeue() {

        if (isEmpty()) {

            throw new IllegalArgumentException("Queue is empty, can not dequeue");
        }
        E e = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity()/2 != 0) {

            resize(getCapacity()/2);
        }
        return e;
    }

    @Override
    public E getFront() {

        if (isEmpty()) {

            throw new IllegalArgumentException("Queue is empty, can not getFront");
        }
        return data[front];
    }

    /*@Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: size is %d, capacity is %d\n", size, data.length - 1);
        res.append("front [");
        if (tail > front) {

            for (int i = front; i < tail; i++) {

                res.append(data[i]);
                if (i != tail - 1) {

                    res.append(", ");
                }
            }
        } else {

            for (int i = front; i < data.length; i++) {

                res.append(data[i]);
                if (i != data.length - 1) {

                    res.append(", ");
                }
            }
            for (int i = 0; i < tail; i++) {

                res.append(", ");
                res.append(data[i]);
            }
        }
        res.append("] tail");
        return res.toString();
    }*/

    //可通过用数组的下标取余数组长度来循环整个数组
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size is %d, capacity is %d\n", size, data.length - 1));
        res.append("front [");
        for (int i = front; i != tail ; i = (i + 1) % data.length) {

            res.append(data[i]);
            if ((i + 1) % data.length != tail) {

                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}