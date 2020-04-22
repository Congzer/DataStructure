package com.congzer.linkdlist;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/16
 **/
public class Main {

    public static void main(String[] args) {

        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        for (int i = 0; i < 5; i++) {

            list.add(i);
            System.out.println(list);
        }
        list.add(2, 666);
        System.out.println(list);
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList);
        for (int i = 0; i < 5; i++) {

            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.remove(0);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println("after remove index of 2 " + linkedList);
        linkedList.add(2, 666);
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}