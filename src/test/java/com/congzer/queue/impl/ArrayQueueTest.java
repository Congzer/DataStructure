package com.congzer.queue.impl;

import com.congzer.queue.Queue;
import org.junit.Test;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/22
 **/
public class ArrayQueueTest {

    @Test
    public void testBasic() {

        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 3; i++) {

            queue.enqueue(i);
            System.out.println(queue);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}