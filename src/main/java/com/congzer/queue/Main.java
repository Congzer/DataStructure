package com.congzer.queue;

import com.congzer.queue.impl.ArrayQueue;
import com.congzer.queue.impl.LinkedListQueue;
import com.congzer.queue.impl.LoopQueue;

import java.util.Random;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/14
 **/
public class Main {

    public static void main(String[] args) {

        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> loopQueue = new LoopQueue<>();
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("arrayQueue: " + performanceTest(arrayQueue, opCount));
        System.out.println("loopQueue: " + performanceTest(loopQueue, opCount));
        System.out.println("linkedListQueue: " + performanceTest(linkedListQueue, opCount));
    }

    private static double performanceTest(Queue<Integer> queue, int opCount) {

        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < opCount; i++) {

            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {

            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}