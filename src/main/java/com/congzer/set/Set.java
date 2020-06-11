package com.congzer.set;

/**
 * @Description 保存的数据不能重复
 * @Author zhangzhucong
 * @Date 2020/6/5
 **/
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}