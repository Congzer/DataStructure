package com.congzer.array;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        /*数组索引可以有语义，也可以没有语义*/
        /*数组最大的优点：快速查询，故数组最好应用于“索引有语义”的情况*/
        /*但并非所有有语义的索引都适用于数组， 比如身份证号*/

        Array<Integer> array = new Array<>(5);
        for (int i = 0; i < 10; i++) {

            array.addLast(i);
        }
        System.out.println(array.getCapacity());
        System.out.println(array);

        array.add(1, 100);
        System.out.println(array);
        System.out.println(array.getCapacity());

        array.addFirst(99);
        System.out.println(array);

        array.remove(0);
        System.out.println(array);

        array.remove(5);
        System.out.println(array);

        array.removeLast();
        System.out.println(array);

        array.removeElement(3);
        System.out.println(array);

        array.addLast(8);
        array.addLast(7);
        System.out.println(array);
        boolean b = array.removeAllElement(7);
        System.out.println(array);
        System.out.println(b);
    }
}
