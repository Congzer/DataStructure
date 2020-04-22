package com.congzer.linkdlist;

/**
 * @Description 链表
 * @Author zhangzhucong
 * @Date 2020/4/15
 **/
//增删改查时间复杂度：O(n) 若增删查只对链表头进行操作： O(1)，又因为它是动态的，不会浪费空间，故具有优势
public class LinkedList<E> {

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

    private Node dummyHead;

    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public int getSize() {

        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    //O(1)
    public void addFirst(E e) {

       add(0, e);
    }

    //O(n)
    public void add(int index, E e) {

        if (index < 0 || index > size) {

            throw new IllegalArgumentException("Add fail. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {

            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    //O(n)
    public void addLast(E e) {

        add(size, e);
    }

    public E get(int index) {

        if (index < 0 || index > size) {

            throw new IllegalArgumentException("Get fail. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {

            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {

        return get(0);
    }

    public E getLast() {

        return get(size - 1);
    }

    //O(n)
    public void set(int index, E e) {

        if (index < 0 || index > size) {

            throw new IllegalArgumentException("Set fail. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {

            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {

        Node cur = dummyHead.next;
        while (cur != null) {

            if (cur.e.equals(e)) {

                return true;
            }
            cur = cur.next;
        }
        return false;

        /*for (int i = 0; i < size; i++) {

            if (cur.e.equals(e)) {

                return true;
            }
            cur = cur.next;
        }
        return false;*/
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        /*Node cur = dummyHead.next;
        while (cur != null) {

            res.append(cur.e).append("->");
            cur = cur.next;
        }*/
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {

            res.append(cur.e).append("->");
        }

        res.append("NULL");
        return res.toString();
    }

    //O(n)
    public E remove(int index) {

        if (index < 0 || index > size) {

            throw new IllegalArgumentException("Set fail. Illegal index.");
        }
        /*Node prev = dummyHead;
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {

            prev = prev.next;
            cur = cur.next;
        }
        prev.next = cur.next;
        cur.next = null;*/
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {

            prev = prev.next;
        }
        Node reNode = prev.next;
        prev.next = reNode.next;
        reNode.next = null;
        size--;
        return reNode.e;
    }

    //O(1)
    public E removeFirst() {

        return remove(0);
    }

    //O(n)
    public E removeLast() {

        return remove(size - 1);
    }
}