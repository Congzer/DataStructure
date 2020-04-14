package com.congzer.queue;

import com.congzer.queue.impl.ArrayQueue;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/14
 **/
public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 3; i++) {

            queue.enqueue(i);
            System.out.println(queue);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}