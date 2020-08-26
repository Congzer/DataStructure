package com.congzer.map;

/**
 * @Description 映射
 * @Author zhangzhucong
 * @Date 2020/6/11
 **/
public interface Map<K, V> {

    // LinkedListMap O(n)  BSTMap O(h) 平均O(logn)
    void add(K key, V value);

    // LinkedListMap O(n)  BSTMap O(h) 平均O(logn)
    V remove(K key);

    // LinkedListMap O(n)  BSTMap O(h) 平均O(logn)
    void set(K key, V value);

    // LinkedListMap O(n)  BSTMap O(h) 平均O(logn)
    V get(K key);

    // LinkedListMap O(n)  BSTMap O(h) 平均O(logn)
    boolean contains(K key);

    int getSize(K key);

    boolean isEmpty();
}