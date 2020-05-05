package com.congzer.linkdlist;

/**
 * @Description 递归学习
 * @Author zhangzhucong
 * @Date 2020/4/27
 **/

/*
* 递归基本原则：
*   1、求解基本问题
*   2、把原问题转化为更小的问题
*
*
* */
public class Recursion {

    public static int sum(int[] arr) {

        return sum(arr, 0);
    }

    private static int sum(int[] arr, int index) {

        if (index == arr.length) {

            return 0;
        }
        return arr[index] + sum(arr, index + 1);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(arr));
    }
}