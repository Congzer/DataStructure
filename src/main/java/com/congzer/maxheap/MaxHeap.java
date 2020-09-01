package com.congzer.maxheap;

import com.congzer.array.Array;

/**
 * @Description: 最大堆
 * @Author: zhangzhucong
 * @Date: 2020/8/31
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap() {

        data = new Array<>();
    }

    public MaxHeap(int capacity) {

        data = new Array<>(capacity);
    }

    public int getSize() {

        return data.getSize();
    }

    public boolean isEmpty() {

        return data.isEmpty();
    }

    public void add(E e) {

        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    public E extraMax() {

        E max = data.get(0);
        data.set(0, data.get(getSize() - 1));
        siftDown();
        return max;
    }

    private void siftDown() {

        int index = 0;
        while (data.get(index).compareTo(data.get(leftChild(index))) < 0 || data.get(index).compareTo(data.get(rightChild(index))) < 0) {

            int maxIndex = data.get(leftChild(index)).compareTo(data.get(rightChild(index))) > 0 ? leftChild(index) : rightChild(index);
            data.swap(index, maxIndex);
            index = maxIndex;
        }
    }

    public static void main(String[] args) {

        MaxHeap<Integer> heap = new MaxHeap<>();
        heap.add(3);
        heap.add(7);
        heap.add(7);
        heap.add(7);
        System.out.println(heap.extraMax());
    }

    private void siftUp(int index) {

        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {

            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {

        if (index == 0) {

            throw new IllegalArgumentException("index with zero has no parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {

        return (index * 2 + 1) >= getSize() ? index : index * 2 + 1;
    }

    private int rightChild(int index) {

        return index * 2 + 2 >= getSize() ? index : index * 2 + 2;
    }
}