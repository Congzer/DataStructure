package com.congzer.map.impl;

import com.congzer.map.Map;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/8/21
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {


    private Node root;

    private int size;

    public BSTMap() {

        this.size = 0;
    }

    @Override
    public void add(K key, V value) {

        if (root == null) {

            root = new Node(key, value);
            return;
        }
        Node node = getNode(key);
        if (node != null) {

            node.value = value;
        } else {

            add(key, value, root);
        }
    }

    private void add(K key, V value, Node node) {

        // 递归终止条件
        if (node.key.compareTo(key) == 0) {

            return;
        } else if (node.key.compareTo(key) > 0 && node.left == null) {

            node.left = new Node(key, value);
        } else if (node.key.compareTo(key) < 0 && node.right == null) {

            node.right = new Node(key, value);
        }

        // 递归
        if (node.key.compareTo(key) > 0) {

            add(key, value, node.left);
        }
        if (node.key.compareTo(key) < 0) {

            add(key, value, node.right);
        }
    }

    // TODO 还未实现
    @Override
    public V remove(K key) {

        Node node = getNode(key);
        if (node == null) {

            throw new IllegalArgumentException("key_no_exist");
        }
        getNode(key, root);
        return null;
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
    public int getSize(K key) {

        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public String toString() {
        return "BSTMap{}";
    }

    private Node getNode(K key) {

        return getNode(key, root);
    }

    private Node getNode(K key, Node node) {

        if (node == null) {

            return null;
        }
        if (node.key.compareTo(key) == 0) {

            return node;
        } else if (node.key.compareTo(key) > 0) {

            return getNode(key, node.left);
        } else {

            return getNode(key, node.right);
        }
    }

    private class Node {

        private K key;

        private V value;

        private Node left;

        private Node right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node() {
        }

        public Node(K key, V value) {

            this(key, value, null, null);
        }
    }
}