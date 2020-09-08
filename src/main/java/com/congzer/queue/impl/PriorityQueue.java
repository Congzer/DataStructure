package com.congzer.queue.impl;

import com.congzer.maxheap.MaxHeap;
import com.congzer.queue.Queue;

/**
 * @Description: 基于最大堆实现的优先队列
 * @Author: zhangzhucong
 * @Date: 2020/9/2
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {

        this.maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {

        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {

        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {

        maxHeap.add(e);
    }

    @Override
    public E dequeue() {

        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {

        return maxHeap.findMax();
    }
}