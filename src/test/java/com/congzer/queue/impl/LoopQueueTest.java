package com.congzer.queue.impl;

import com.congzer.queue.Queue;
import org.junit.Test;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/22
 **/
public class LoopQueueTest {

    @Test
    public void testBasic() {

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
}