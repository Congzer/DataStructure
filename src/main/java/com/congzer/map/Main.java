package com.congzer.map;

import com.congzer.map.impl.LinkedListMap;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/8/21
 **/
public class Main {

    public static void main(String[] args) {

        linkedListMapBasicTest();

    }

    private static void linkedListMapBasicTest() {

        Map<String, String> map = new LinkedListMap<>();
        map.add("1", "a");
        map.add("2", "b");
        map.add("3", "c");
        System.out.println("add: " + map);

        map.set("3", "cc");
        System.out.println("set: " + map);

        System.out.println("get: " + map.get("3"));

        map.remove("3");
        System.out.println("remove: " + map);

        System.out.println("remove: " + map.contains("3"));
    }
}
