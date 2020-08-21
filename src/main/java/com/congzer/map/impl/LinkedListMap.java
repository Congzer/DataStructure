package com.congzer.map.impl;

import com.congzer.map.Map;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/8/21
 **/
public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyNode;

    private int size;

    public LinkedListMap() {

        this.dummyNode = new Node(null, null, null);
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {

        Node node = getNode(key);
        if (node != null) {

            node.value = value;
        } else {

            dummyNode.next = new Node(key, value, dummyNode.next);
        }
        size++;
    }

    @Override
    public V remove(K key) {

        Node pre = dummyNode;
        Node cur = dummyNode.next;
        while (cur != null) {

            if (cur.key.equals(key)) {

                pre.next = cur.next;
                cur.next = null;
                size--;
                return cur.value;
            }
            pre = pre.next;
            cur = cur.next;
        }
        throw new IllegalArgumentException("not_find");
    }

    @Override
    public void set(K key, V value) {

        Node node = getNode(key);
        if (node == null) {

            throw new IllegalArgumentException("key_no_exist");
        }
        node.value = value;
    }

    @Override
    public V get(K key) {

        Node node = getNode(key);
        if (node == null) {

            throw new IllegalArgumentException("key_no_exist");
        }
        return node.value;
    }

    @Override
    public boolean contains(K key) {

        return getNode(key) != null;
    }

    @Override
    public int getSize(Object key) {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("LinkedListMap{");
        Node cur = dummyNode.next;
        while (cur != null) {

            builder.append(cur.key);
            builder.append(":");
            builder.append(cur.value);
            if (cur.next != null) {

                builder.append(", ");
            }
            cur = cur.next;
        }
        builder.append("}");
        return builder.toString();
    }

    /* 根据key找到相应的node */
    private Node getNode(K key) {

        Node cur = dummyNode.next;
        // 遍历链表
        while (cur != null) {

            if (cur.key.equals(key)) {

                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    private class Node {

        private K key;

        private V value;

        private Node next;

        public Node(K key, V value, Node next) {

            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node() {
        }

        public Node(K key) {

            this(key, null, null);
        }

        @Override
        public String toString() {

            return key.toString() + ":" + value.toString();
        }
    }
}