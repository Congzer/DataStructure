package com.congzer.maxheap;

public interface IMaxHeap<E> {

    // O(logn)
    void add(E e);

    // O(logn)
    E extractMax();

    // O(logn)
    E replace(E e);

    // O(n)
    void Heapify();
}