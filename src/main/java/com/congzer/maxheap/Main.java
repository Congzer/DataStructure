package com.congzer.maxheap;

import java.util.Random;

/**
 * @Description:
 * @Author: zhangzhucong
 * @Date: 2020/9/2
 */
public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        int length = 1000000;
        Integer[] arr = new Integer[length];

        for (int i = 0; i < length; i++) {

            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        System.out.println("with heapify: " + test(arr, true) + " s");
        System.out.println("without heapify: " + test(arr, false) + " s");
    }

    private static double test(Integer[] arr, boolean isHeapify) {

        long startTime = System.nanoTime();
        MaxHeap<Integer> heap;
        if (isHeapify) {

            heap = new MaxHeap<>(arr);
        } else {

            heap = new MaxHeap<>();
            for (Integer integer : arr) {

                heap.add(integer);
            }
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            result[i] = heap.extractMax();
        }
        for (int i = 1; i < result.length; i++) {

            if (result[i - 1] < result[i]) {

                throw new IllegalArgumentException("error_max_heap");
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / Math.pow(10, 9);
    }
}