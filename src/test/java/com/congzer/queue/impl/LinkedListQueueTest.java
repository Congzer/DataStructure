package com.congzer.queue.impl;

import com.congzer.queue.Queue;
import org.junit.Test;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/20
 **/
public class LinkedListQueueTest {

    @Test
    public void testBasic() {

        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 2; i++) {

            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 2; i++) {

            queue.dequeue();
            System.out.println(queue);
        }
    }
}