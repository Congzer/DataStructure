package com.congzer.leetcode;

import com.congzer.queue.Queue;
import com.congzer.queue.impl.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description: 从n中选出前m类型问题，n>>m, 使用归类排序，快速排序等高级排序时间复杂度可为O(nlogn)，使用优先队列可为O(nlonm)
 * log是以2为底，当n为百万，m为一百时，logn约为20，logm约为7
 * @Author: zhangzhucong
 * @Date: 2020/9/2
 */
public class SelectHighFrequencyElement_347 {

    public static void main(String[] args) {

        /*Freq freq1 = new Freq(1, 1);
        Freq freq3 = new Freq(3, 3);
        Freq freq2 = new Freq(2, 2);
        List<Freq> freqs = Arrays.asList(freq1, freq3, freq2);
        freqs.sort(new FreqComparator());
        System.out.println(freqs);*/
        int[] nums = new int[]{5,2,2,2,2,2,3, 3, 3,3,3,3,3, 4, 4, 4, 4, 0, 1, 0};
        SelectHighFrequencyElement_347 s = new SelectHighFrequencyElement_347();
        int[] ints = s.topKFrequentWithJavaPriorityQueueAndComparatorSimplifiedVersion(nums, 3);
        for (int anInt : ints) {

            System.out.println(anInt);
        }
    }

    /**
     *  生成一个长度为n的优先队列，队首放着n个元素中出现频次最大的元素
     *  将传入的数组中的元素按照出现频率排序，并返回前k个元素
     *  时间复杂度：O(n * 2logn) + O(m * 2logm) + O(k * logm)
     * @param nums
     * @param k 返回元素个数
     * @return 具有k个元素的数组
     */
    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        Queue<FreqMax> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new TreeMap<>();

        // O(n * 2logn)
        for (int num : nums) {

            Integer freq = map.getOrDefault(num, 0); // O(logn)
            map.put(num, freq + 1); // O(logn)
        }

        // O(m * 2logm)
        for (Integer num : map.keySet()) {

            Integer freq = map.get(num); // O(logm)
            queue.enqueue(new FreqMax(num, freq)); // O(logm)
        }

        // O(k * logm)
        for (int i = 0; i < k; i++) {

            result[i] = queue.dequeue().e;
        }
        return result;
    }

    /**
     *  维护一个长度为k的队列，队首放着k个元素中频次出现最小的元素
     *  将传入的数组中的元素按照出现频率排序，并返回前k个元素
     *  时间复杂度：O(n * 2logn) + O(m * (logm + logk)) + O(k * logk) n为参数数组中元素个数， m为参数数组中不重复的元素的个数
     * @param nums
     * @param k 返回元素个数
     * @return 具有k个元素的数组
     */
    public int[] topKFrequent2(int[] nums, int k) {

        int[] result = new int[k];
        Queue<FreqMin> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        // O(n * (logn + logn))
        for (int num : nums) {

            Integer freq = map.getOrDefault(num, 0); // O(logn)
            map.put(num, freq + 1); // O(logn)
        }

        // O(m * (logm + logk))
        for (Integer num : map.keySet()) {

            if (queue.getSize() < k) {

                // 先往优先队列中存放k个元素, 元素频次越小优先级越高
                Integer value = map.get(num); // O(logm)
                queue.enqueue(new FreqMin(num, value)); // O(logk)
            } else if (map.get(num) > queue.getFront().freq) {

                // 从第 k+1 个元素开始，判断该元素出现的频次是否大于队列中队首元素（频次最小）的频次，如果大于，则队首出队，再放于元素
                queue.dequeue(); // O(1)
                Integer value = map.get(num); // O(logm)
                queue.enqueue(new FreqMin(num, value)); // O(logk)
            }
        }

        // O(k * logk)
        for (int i = 0; i < k; i++) {

            result[i] = queue.dequeue().e;
        }
        return result;
    }

    /* Java 优先队列基于最小堆实现 */
    public int[] topKFrequentWithJavaPriorityQueue(int[] nums, int k) {

        int[] result = new int[k];
        java.util.Queue<FreqMax> queue = new java.util.PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        // O(n * (logn + logn))
        for (int num : nums) {

            Integer freq = map.getOrDefault(num, 0); // O(logn)
            map.put(num, freq + 1); // O(logn)
        }

        // O(m * (logm + logk))
        for (Integer num : map.keySet()) {

            if (queue.size() < k) {

                // 先往优先队列中存放k个元素, 元素频次越小优先级越高（最小堆）
                Integer value = map.get(num); // O(logm)
                queue.add(new FreqMax(num, value)); // O(logk)
            } else if (map.get(num) > queue.peek().freq) {

                // 从第 k+1 个元素开始，判断该元素出现的频次是否大于队列中队首元素（频次最小）的频次，如果大于，则队首出队，再放于元素
                queue.remove(); // O(1)
                Integer value = map.get(num); // O(logm)
                queue.add(new FreqMax(num, value)); // O(logk)
            }
        }

        // O(k * logk)
        for (int i = 0; i < k; i++) {

            result[i] = queue.remove().e;
        }
        return result;
    }

    /* Java 优先队列基于最小堆实现 */
    public int[] topKFrequentWithJavaPriorityQueueAndComparator(int[] nums, int k) {

        int[] result = new int[k];
        java.util.Queue<Freq> queue = new java.util.PriorityQueue<>(new FreqComparator());
        Map<Integer, Integer> map = new HashMap<>();

        // O(n * (logn + logn))
        for (int num : nums) {

            Integer freq = map.getOrDefault(num, 0); // O(logn)
            map.put(num, freq + 1); // O(logn)
        }

        // O(m * (logm + logk))
        for (Integer num : map.keySet()) {

            if (queue.size() < k) {

                // 先往优先队列中存放k个元素, 元素频次越小优先级越高（最小堆）
                Integer value = map.get(num); // O(logm)
                queue.add(new Freq(num, value)); // O(logk)
            } else if (map.get(num) > queue.peek().freq) {

                // 从第 k+1 个元素开始，判断该元素出现的频次是否大于队列中队首元素（频次最小）的频次，如果大于，则队首出队，再放于元素
                queue.remove(); // O(1)
                Integer value = map.get(num); // O(logm)
                queue.add(new Freq(num, value)); // O(logk)
            }
        }

        // O(k * logk)
        for (int i = 0; i < k; i++) {

            result[i] = queue.remove().e;
        }
        return result;
    }

    public int[] topKFrequentWithJavaPriorityQueueAndComparatorSimplifiedVersion(int[] nums, int k) {

        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        // O(n * (logn + logn))
        for (int num : nums) {

            Integer freq = map.getOrDefault(num, 0); // O(1)
            map.put(num, freq + 1); // O(logn)
        }
        java.util.Queue<Integer> queue = new java.util.PriorityQueue<>(Comparator.comparingInt(map::get));

        // O(m * (logm + logk))
        for (Integer num : map.keySet()) {

            if (queue.size() < k) {

                // 先往优先队列中存放k个元素, 元素频次越小优先级越高（最小堆）
                queue.add(num); // O(logk)
            } else if (map.get(num) > map.get(queue.peek())) {

                // 从第 k+1 个元素开始，判断该元素出现的频次是否大于队列中队首元素（频次最小）的频次，如果大于，则队首出队，再放于元素
                queue.remove(); // O(1)
                queue.add(num); // O(logk)
            }
        }

        // O(k * logk)
        for (int i = 0; i < k; i++) {

            result[i] = queue.remove();
        }
        return result;
    }

    // 比较器
    private static class FreqComparator implements Comparator<Freq> {

        @Override
        public int compare(Freq o1, Freq o2) {

            // freq小的拍前面
            int min = o1.freq - o2.freq;
            // freq大的拍前面
            int max = o2.freq - o1.freq;
            return min;
        }
    }

    // 出现频次越大，在比较中越大
    private static class FreqMax implements Comparable<FreqMax> {

        int e;

        int freq;

        public FreqMax(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(FreqMax o) {

            if (this.freq > o.freq) {

                return 1;
            } else if (this.freq < o.freq) {

                return -1;
            }
            return 0;
        }
    }

    // 出现频次越小，在比较中越大
    private static class FreqMin implements Comparable<FreqMin> {

        int e;

        int freq;

        public FreqMin(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(FreqMin o) {

            if (this.freq < o.freq) {

                return 1;
            } else if (this.freq > o.freq) {

                return -1;
            }
            return 0;
        }
    }

    // 出现频次越大，在比较中越大
    private static class Freq {

        int e;

        int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public String toString() {
            return "Freq{" +
                    "e=" + e +
                    ", freq=" + freq +
                    '}';
        }
    }
}