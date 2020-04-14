package com.congzer.queue;

/**
 * @Description 队列接口
 * @Author zhangzhucong
 * @Date 2020/4/14
 **/
public interface Queue<E> {

    //O(1)
    int getSize();

    //O(1)
    boolean isEmpty();

    //入队 （往队尾添加元素） 均摊O(1)
    void enqueue(E e);

    //出队 （删除队首元素） O(n)
    E dequeue();

    //获取队首元素 O(1)
    E getFront();
}