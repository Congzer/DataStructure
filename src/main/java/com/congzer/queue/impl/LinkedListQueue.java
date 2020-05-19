package com.congzer.queue.impl;

import com.congzer.queue.Queue;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/20
 **/
public class LinkedListQueue<E> implements Queue<E> {

    //节点类
    private class Node{

        public E e;

        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {

            return e.toString();
        }
    }

    private Node head, tail;

    private int size;

    public LinkedListQueue() {

        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //链尾入队 O(1)
    @Override
    public void enqueue(E e) {

        if (tail == null) {

            tail = new Node(e);
            head = tail;
        } else {

            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    //链首出队  O(1)
    @Override
    public E dequeue() {

        if (isEmpty()) {

            throw new IllegalArgumentException("Dequeue fail, it is empty");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {

            //队列中只有一个元素
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {

        if (isEmpty()) {

            throw new IllegalArgumentException("Dequeue fail, it is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue front: ");
        Node cur = head;
        while (cur != null) {

            res.append(cur).append("->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
