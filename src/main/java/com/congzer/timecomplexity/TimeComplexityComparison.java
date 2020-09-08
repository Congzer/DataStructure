package com.congzer.timecomplexity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @Description: 时间复杂度比较类
 * @Author: zhangzhucong
 * @Date: 2020/9/3
 */
public class TimeComplexityComparison {

    public static void main(String[] args) {

        TimeComplexityComparison comparison = new TimeComplexityComparison();
        comparison.compareLognWithLogkInPriorityQueue();
    }

    private void compareLognWithLogkInPriorityQueue() {

        Random random = new Random();
        int n = 1000000;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {

            data[i] = random.nextInt(100000);
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int key : data) {

            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        double t1 = getExecuteTime(map, true);
    }

    private double getExecuteTime(Map<Integer, Integer> map, boolean isLogk) {

        long startTime = System.nanoTime();
        if (isLogk) {


        } else {


        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / Math.pow(10, 9);
    }
}