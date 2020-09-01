package com.congzer.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 输入两个数组，输出他们的交集数组（元素重复）；Map
 * @Author: zhangzhucong
 * @Date: 2020/8/27
 */
public class GetIntersectionOfTwoArray_350 {

    public static void main(String[] args) {

        int[] num1 = new int[]{4,4,9,5};
        int[] num2 = new int[]{9,4,9,8,4};
        int[] intersection = new GetIntersectionOfTwoArray_350().getIntersection(num1, num2);
        for (int i : intersection) {

            System.out.println(i);
        }
    }

    // 时间复杂度：O(m+n), 空间复杂度：O(min(m,n))
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {

            // 保证nums1长度比nums2短
            return intersect(nums2, nums1);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        // 存放较短数组的元素以及其出现的频次
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) map.put(i, map.getOrDefault(i, 0) + 1);

        for (int i : nums2) {

            if (map.containsKey(i)) {

                intersection[index++] = i;
                Integer count = map.get(i);
                if (count == 1) map.remove(i);
                else map.put(i, count - 1);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    // 时间复杂度：O(m*n), ArrayList的remove时间复杂度为0(n), 空间复杂度：O(m+n)
    public int[] getIntersection(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {

            return getIntersection(nums2, nums1);
        }
        List<Integer> list = new ArrayList<>();
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int i : nums2) list.add(i);
        for (Integer i : nums1) {

            if (list.contains(i)) {

                intersection[index++] = i;
                list.remove(i);
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}