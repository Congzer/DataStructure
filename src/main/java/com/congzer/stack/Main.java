package com.congzer.stack;


import com.congzer.stack.impl.ArrayStack;
import com.congzer.stack.impl.LinkedStack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /*Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {

            stack.push(i);
        }
        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);
*/
        //System.out.println(test("{([[)}"));
        /*System.out.println(": " + test(""));
        System.out.println("]]]]: " + test("]]]]"));
        System.out.println("{{{{: " + test("{{{{"));
        System.out.println("{[(]: " + test("{[(]"));
        System.out.println("{}[]((: " + test("{}[](("));
        System.out.println("{}[](): " + test("{}[]()"));
        System.out.println("{({})}: " + test("{({})}"));*/

        int opCount = 100000;
        Stack<Integer> arrayStack = new ArrayStack<>();
        Stack<Integer> linkedStack = new LinkedStack<>();
        System.out.println("arrayStack: " + stackPerformanceTest(arrayStack, opCount));
        System.out.println("linkedStack: " + stackPerformanceTest(linkedStack, opCount));
    }

    private static Double stackPerformanceTest(Stack<Integer> stack, int opCount) {

        long beginTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {

            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {

            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - beginTime) / 1000000000.0;

    }

    private static boolean test(String s) {

        Stack<Character> stack = new ArrayStack<>();

        if (s.length() == 0) {

            return false;
        }
        for (char c : s.toCharArray()) {

            if ('{' == (c)  || '(' == (c) || '[' == (c)) {

                stack.push(c);
            }
            if (stack.isEmpty()) {

                return false;
            }
            if ('}' == c && '{' != stack.pop()) {

                return false;
            }
            if (']' == c && '[' != stack.pop()) {

                return false;
            }
            if (')' == c && '(' != stack.pop()) {

                return false;
            }
        }
        return stack.isEmpty();
    }

    //LeeCode 20 括号匹配 使用自己的栈数据结构实现
    private static boolean test2(String s) {

        Stack<Character> stack = new ArrayStack<>();
        for (char c : s.toCharArray()) {

            if ('{' == c || '(' == c || '[' == c) {

                stack.push(c);
            }
            if (stack.isEmpty()) {

                return false;
            }
            Character topChar = stack.pop();
            if ('}' == c && '{' != topChar) {

                return false;
            }
            if (')' == c && '(' != topChar) {

                return false;
            }
            if (']' == c && '[' != topChar) {

                return false;
            }
        }
        return stack.isEmpty();
    }

}
