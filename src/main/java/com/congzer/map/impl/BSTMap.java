package com.congzer.map.impl;

import com.congzer.map.Map;

/**
 * @Description 基于二分搜索树实现的映射
 * @Author zhangzhucong
 * @Date 2020/8/21
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private Node root;

    private int size;

    public BSTMap() {

        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {

        root = add(root, key, value);

    }

    private Node add(Node node, K key, V value) {

        if (node == null) {

            size++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) > 0) {

            node.left = add(node.left, key, value);
        } else if (node.key.compareTo(key) < 0) {

            node.right = add(node.right, key, value);
        } else {

            node.value = value;
        }
        return node;
    }

    // TODO 还未实现
    @Override
    public V remove(K key) {

        Node node = getNode(key);
        if (node == null) {

            throw new IllegalArgumentException("key_no_exist");
        }
        root = remove(root, key);
        return node.value;
    }

    private Node remove(Node node, K key) {

        if (node == null) {

            return null;
        }
        if (node.key.compareTo(key) > 0) {

            node.left = remove(node.left, key);
            return node;
        } else if (node.key.compareTo(key) < 0) {

            node.right = remove(node.right, key);
            return node;
        } else {

            if (node.left == null) {

                // 待删除节点的左节点为空时，返回右节点以替换待删除节点
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {

                // 待删除节点的右节点为空时，返回左节点以替换待删除节点
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点的左右节点都不为空时，找到比待删除节点大的最小节点，即待删除节点右子树中的最小节点，返回该节点以替换待删除节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }

    private Node removeMin(Node node) {

        if (node.left == null) {

            Node tem = node.right;
            node.right = null;
            size--;
            return tem;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node node) {

        if (node.left == null) {

            return node;
        }
        return minimum(node.left);
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