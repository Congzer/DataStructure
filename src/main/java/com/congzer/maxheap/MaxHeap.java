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

    // Heapify,堆化，传入任意一个数组，将其转换成最大堆， O(n)
    // 1、找到数组中最后一个非叶子节点 parent(arr.length - 1)
    // 2、从最后一个非叶子节点从后遍历进行下沉操作
    // 若从数组中一个一个使用add方法放入堆中，时间复杂度为 O(nlogn)
    public MaxHeap(E[] arr) {

        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {

            siftDown(i);
        }
    }

    public int getSize() {

        return data.getSize();
    }

    public boolean isEmpty() {

        return data.isEmpty();
    }

    // O(logn)
    public void add(E e) {

        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    // O(logn)
    public E extractMax() {

        E max = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    public E findMax() {

        if (data.getSize() == 0) {

            throw new IllegalArgumentException("empty");
        }
        return data.get(0);
    }

    // O（logn）取出最大值，并放入一个新的值
    public E replace(E e) {

        E max = findMax();
        // 添加元素
        data.set(0, e);
        // 第一位下沉
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {

        // 当索引为index的节点的左子节点索引小于数组长度时，此时该节点一定没有子节点
        while (leftChild(index) < data.getSize()) {

            int maxIndex = leftChild(index);
            if (maxIndex + 1 < data.getSize() && data.get(maxIndex + 1).compareTo(data.get(maxIndex)) > 0) {

                // 此时存在右子节点，且右字节点得值大于左子节点
                maxIndex = maxIndex + 1;
            }

            // 父节点大于等于子节点时，结束循环
            if (data.get(index).compareTo(data.get(maxIndex)) >= 0) {

                break;
            }

            // 父节点小于子节点时, 进行交换
            data.swap(index, maxIndex);
            index = maxIndex;
        }
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

        return index * 2 + 1;
    }

    private int rightChild(int index) {

        return index * 2 + 2;
    }
}