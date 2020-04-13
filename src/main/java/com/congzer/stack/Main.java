package com.congzer.stack;


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
        System.out.println(": " + test(""));
        System.out.println("]]]]: " + test("]]]]"));
        System.out.println("{{{{: " + test("{{{{"));
        System.out.println("{[(]: " + test("{[(]"));
        System.out.println("{}[]((: " + test("{}[](("));
        System.out.println("{}[](): " + test("{}[]()"));
        System.out.println("{({})}: " + test("{({})}"));
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
            if (']' == (c)  || ')' == (c) || '}' == (c)) {

                if (stack.isEmpty()) {

                    return false;
                }
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

    private static boolean test2(String s) {

        Stack<String> stack = new ArrayStack<>();

        if (s.length() == 0) {

            return false;
        }
        for (char c : s.toCharArray()) {

            String cStr = c + "";
            if ("{".equals(cStr) || "(".equals(cStr) || "[".equals(cStr)) {

                stack.push(cStr);
                continue;
            }
            if ("]".equals(cStr) && !"[".equals(stack.peek())) {

                return false;
            }
            if (")".equals(cStr) && !"(".equals(stack.peek())) {

                return false;
            }
            if ("}".equals(cStr) && !"{".equals(stack.peek())) {

                return false;
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    java.util.Stack<Character> stack = new java.util.Stack<>();
}
