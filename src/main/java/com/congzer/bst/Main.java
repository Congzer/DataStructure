package com.congzer.bst;

import java.util.Random;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/5/25
 **/
public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        //int[] arr = {5, 3, 6, 8, 4, 2};
        int[] arr = {18, 16, 14, 21, 20, 24};
        for (int i = 0; i < arr.length; i++) {

            bst.add2(arr[i]);
        }
//        bst.proOrder();
//        System.out.println();
//
//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();
//
//        bst.leverOrder();

        /*System.out.println("min:" + bst.minimum());
        System.out.println("max: " + bst.maximum());
        bst.removeMax();
        bst.removeMin();
        bst.inOrder();*/
        //System.out.println("max: " + bst.maximum());
        //System.out.println("min: " + bst.minimum());
    }
}
