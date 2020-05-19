package com.congzer.bst;

/**
 * @Description Binary Search Tree
 * @Author zhangzhucong
 * @Date 2020/5/19
 **/
public class BST<E extends Comparable<E>> {

    private Node root; //根节点

    private int size;

    public BST() {

        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    //增加元素
    public void add(E e) {

        if (root == null) {

            root = new Node(e);
            size ++;
        } else {

            addWithRecursion(root, e);
        }
    }

    // 递归算法
    private void addWithRecursion(Node node, E e) {

        // 算法终止条件
        if (e.equals(node.e)) {

            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {

            node.right = new Node(e);
            size ++;
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {

            node.left = new Node(e);
            size ++;
            return;
        }

        // 执行递归
        if (e.compareTo(node.e) > 0) {

            addWithRecursion(node.right, e);
        } else {

            addWithRecursion(node.left, e);
        }
    }

    //增加元素
    public void add2(E e) {

        root = addWithRecursion2(root, e);
    }

    // 递归算法 返回插入新节点后二分搜索树的根
    private Node addWithRecursion2(Node node, E e) {

        // 算法终止条件
        if (node == null) {

            size ++;
            return new Node(e);
        }

        // 执行递归
        if (e.compareTo(node.e) > 0) {

            node.right = addWithRecursion2(node.right, e);
        } else if(e.compareTo(node.e) < 0) {

            node.left = addWithRecursion2(node.left, e);
        }
        return node;
    }


    private class Node {

        private E e;
        private Node left, right;

        public Node(E e) {

            this.e = e;
            left = null;
            right = null;
        }
    }
}