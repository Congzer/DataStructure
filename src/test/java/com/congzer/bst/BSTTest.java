package com.congzer.bst;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/6/1
 **/
public class BSTTest {

    private BST<Integer> bst = new BST<>();

    @Test
    public void removeMin_happyPath() {

        int n = 1000;
        Random random = new Random();

        for (int i = 0; i < n; i++) {

            bst.add2(random.nextInt(10000));
        }
        List<Integer> list = new ArrayList<>();
        while (!bst.isEmpty()) {

            list.add(bst.removeMin());
        }
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i - 1) >= list.get(i)) {

                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Success");
    }

    @Test
    public void remove_happyPath() {

        List<Integer> list = Arrays.asList(5, 3, 6, 8, 4, 2);
        bst.addAll(list);
        bst.remove(8);

        assertFalse(bst.contains(8));
    }
}