package com.congzer.map;

/**
 * @Description 映射
 * @Author zhangzhucong
 * @Date 2020/6/11
 **/
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    void set(K key, V value);

    V get(K key);

    boolean contains(K key);

    int getSize(K key);

    boolean isEmpty();
}