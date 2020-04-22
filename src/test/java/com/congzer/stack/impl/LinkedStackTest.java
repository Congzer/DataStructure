package com.congzer.stack.impl;

import com.congzer.stack.Stack;
import org.junit.Test;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/20
 **/
public class LinkedStackTest {

    @Test
    public void testBasic() {

        Stack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 5; i++) {

            stack.push(i);
            System.out.println(stack);
        }
        stack.push(666);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());
    }
}