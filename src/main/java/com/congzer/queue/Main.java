package com.congzer.queue;

import com.congzer.queue.impl.ArrayQueue;
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
        System.out.println("arrayQueue: " + testQueue(arrayQueue, opCount));
        System.out.println("loopQueue: " + testQueue(loopQueue, opCount));
    }

    private static double testQueue(Queue<Integer> queue, int opCount) {

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

    private static void test() {

        Integer i = 500;
        Integer j = 500;
        System.out.println(i.equals(j));
    }


    private static void loopQueueTest() {

        Queue<Integer> queue = new LoopQueue<>();
        System.out.println("入队：");
        for (int i = 0; i < 11; i++) {

            queue.enqueue(i);
            System.out.println(queue);
        }

        System.out.println("出队：");
        for (int i = 0; i < 4; i++) {

            queue.dequeue();
            System.out.println(queue);
        }

        System.out.println("入队：");
        for (int i = 0; i < 3; i++) {

            queue.enqueue(9 + i);
            System.out.println(queue);
        }

        System.out.println("出队：");
        for (int i = 0; i < 10; i++) {

            queue.dequeue();
            System.out.println(queue);
        }
    }

    private static void arrayQueueTest() {

        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 3; i++) {

            queue.enqueue(i);
            System.out.println(queue);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}