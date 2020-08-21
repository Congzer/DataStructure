package com.congzer.set.impl;

import com.congzer.bst.BST;
import com.congzer.set.Set;

/**
 * @Description 二分搜索树实现的集合，有序
 * @Author zhangzhucong
 * @Date 2020/6/5
 **/
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {

        this.bst = new BST<>();
    }

    // O(h) = (平均)O(logn) h为树的高度，此时，若是满二叉树，则有2的(h-1)次方的节点, h=log₂(n+1) h=O(log₂n),一般log的底不重要，故为logn
    @Override
    public void add(E e) {

        bst.add2(e);
    }

    // O(h) = O(logn) h为树的高度
    @Override
    public void remove(E e) {

        bst.remove(e);
    }

    // O(h) = O(logn) h为树的高度
    @Override
    public boolean contains(E e) {

        return bst.contains(e);
    }

    @Override
    public int getSize() {

        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {

        return bst.isEmpty();
    }
}