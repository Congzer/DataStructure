package com.congzer.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description: 输入两个数组，输出他们的交集数组(其中元素不重复)；Set
 * @Author: zhangzhucong
 * @Date: 2020/8/27
 */
public class Num349 {

    public static void main(String[] args) {

        int[] num1 = new int[]{4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};
        int[] intersection = new Num349().getIntersection(num1, num2);
        for (int i : intersection) {

            System.out.println(i);
        }
    }

    // O(m+n), 其中集合的contains平均为O(1)
    public int[] getIntersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = putInSet(nums1);
        Set<Integer> set2 = putInSet(nums2);
        // 优化，遍历元素个数较小的set
        if (set1.size() <= set2.size()) {

            return toIntArray(set1.stream().filter(set2::contains).collect(Collectors.toSet()));
        } else {

            return toIntArray(set2.stream().filter(set1::contains).collect(Collectors.toSet()));
        }
    }

    private int[] toIntArray(Set<Integer> intersection) {

        int[] ints = new int[intersection.size()];
        int index = 0;
        for (Integer integer : intersection) {

            ints[index] = integer;
            index++;
        }
        return ints;
    }

    private Set<Integer> putInSet(int[] num) {

        Set<Integer> set = new HashSet<>();
        for (int i : num) {

            set.add(i);
        }
        return set;
    }
}