package com.congzer.bst;

import com.congzer.queue.Queue;
import com.congzer.queue.impl.LinkedListQueue;
import com.congzer.stack.Stack;
import com.congzer.stack.impl.LinkedStack;

import java.util.Collection;

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

    /*********************************************** 增加元素 *****************************************************/

    public void add(E e) {

        if (root == null) {

            root = new Node(e);
            size++;
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
            size++;
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {

            node.left = new Node(e);
            size++;
            return;
        }

        // 执行递归
        if (e.compareTo(node.e) > 0) {

            addWithRecursion(node.right, e);
        } else {

            addWithRecursion(node.left, e);
        }
    }

    // 优化版
    public void add2(E e) {

        root = addWithRecursion2(root, e);
    }

    public void addAll(Collection<E> es) {

        for (E e : es) {

            add2(e);
        }
    }

    // 递归算法 返回插入新节点后二分搜索树的根
    private Node addWithRecursion2(Node node, E e) {

        // 算法终止条件
        if (node == null) {

            size++;
            return new Node(e);
        }

        // 执行递归
        if (e.compareTo(node.e) > 0) {

            node.right = addWithRecursion2(node.right, e);
        } else if (e.compareTo(node.e) < 0) {

            node.left = addWithRecursion2(node.left, e);
        }
        return node;
    }

    /*********************************************** 查询元素 *****************************************************/

    // 判断是否包含元素e
    public boolean contains(E e) {

        return containsWithRecursion(root, e);
    }

    // 查询最小元素
    public E minimum() {

        if (root == null) {

            throw new IllegalArgumentException("BST is empty!");
        }
        return minimumWithRecursion(root).e;
        //return minimumWithStack(root);
    }

    private E minimumWithStack(Node node) {

        Stack<Node> stack = new LinkedStack<>();
        stack.push(node);
        while (!stack.isEmpty()) {

            Node cur = stack.pop();
            if (cur.left == null) {

                return cur.e;
            }
            stack.push(cur.left);
        }
        throw new IllegalArgumentException("BST is empty!");
    }

    // 查询最大元素
    public E maximum() {

        if (root == null) {

            throw new IllegalArgumentException("BST is empty!");
        }
        return maximumWithRecursion(root).e;
        //return maximumWithStack(root);
    }

    private E maximumWithStack(Node node) {

        Stack<Node> stack = new LinkedStack<>();
        stack.push(node);
        while (!stack.isEmpty()) {

            Node cur = stack.pop();
            if (cur.right == null) {

                return cur.e;
            }
            stack.push(cur.right);
        }
        throw new IllegalArgumentException("BST is empty!");
    }

    private Node minimumWithRecursion(Node node) {

        if (node.left == null) {

            return node;
        }
        return minimumWithRecursion(node.left);
    }

    private Node maximumWithRecursion(Node node) {

        if (node.right == null) {

            return node;
        }
        return maximumWithRecursion(node.right);
    }

    private boolean containsWithRecursion(Node node, E e) {

        if (node == null) {

            return false;
        }

        if (e.compareTo(node.e) == 0) {

            return true;
        } else if (e.compareTo(node.e) > 0) {

            return containsWithRecursion(node.right, e);
        } else {

            return containsWithRecursion(node.left, e);
        }
    }

    /*********************************************** 删除元素 *****************************************************/
    public E removeMin() {

        E ret = minimum();
        root = removeMinWithRecursion(root);
        return ret;
    }

    public E removeMax() {

        E ret = maximum();
        root = removeMaxWithRecursion(root);
        return ret;
    }

    public void remove(E e) {

        if (!contains(e)) {

            throw new IllegalArgumentException("fail to remove, BST not contain e");
        }
        root = removeWithRecursion(root, e);
    }

    private Node removeWithRecursion(Node node, E e) {

        if (node == null) {

            return null;
        }
        if (e.compareTo(node.e) < 0) {

            node.left = removeWithRecursion(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0) {

            node.right = removeWithRecursion(node.right, e);
            return node;
        }
        else {

            // 待删除元素左子树为null
            if (node.left == null) {

                Node tem = node.right;
                node.right = null;
                size--;
                return tem;
            }

            // 待删除元素右子树为null
            if (node.right == null) {

                Node tem = node.left;
                node.left = null;
                size--;
                return tem;
            }

            // 待删除元素左右子树都不为null，此时找到待删除节点下的最小节点，即待删除节点右子树的最小节点，用该节点替换待删除节点
            Node successor = minimumWithRecursion(node.right);
            successor.right = removeMinWithRecursion(node.right);
            successor.left = node.left;
            node.right = node.left = null;
            return successor;
        }
    }

    // 删除以node为根的二分搜索树的最小节点，并返回删除节点后新的二分搜索树的根
    private Node removeMinWithRecursion(Node node) {

        if (node.left == null) {

            Node tem = node.right;
            node.right = null;
            size--;
            return tem;
        }
        node.left = removeMinWithRecursion(node.left);
        return node;
    }

    // 删除以node为根的二分搜索树的最大节点，并返回删除节点后新的二分搜索树的根
    private Node removeMaxWithRecursion(Node node) {

        if (node.right == null) {

            Node tem = node.left;
            node.left = null;
            size--;
            return tem;
        }
        node.right = removeMaxWithRecursion(node.right);
        return node;
    }

    /*********************************************** 遍历 *****************************************************/

    // 前序遍历，先访问根节点,再访问左右节点
    public void proOrder () {

        proOrderWithRecursion(root);
        proOrderWithStack(root);
    }

    // 中序遍历，先访问左子树,再访问节点，最后访问右子树
    public void inOrder () {

        inOrderWithRecursion(root);
    }

    // 后序遍历，先访问左子树,再访问访问右子树，最后访问节点
    public void postOrder () {

        postOrderWithRecursion(root);
    }

    // 层序遍历，使用队列来实现
    public void leverOrder() {

        Queue<Node> queue = new LinkedListQueue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {

            Node cur = queue.dequeue();
            System.out.println(cur.e);

            if (cur.left != null) {

                queue.enqueue(cur.left);
            }
            if (cur.right != null) {

                queue.enqueue(cur.right);
            }
        }
    }

    // 前序遍历非递归实现
    private void proOrderWithStack(Node root) {

        Stack<Node> stack = new LinkedStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {

            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {

                stack.push(cur.right);
            }
            if (cur.left != null) {

                stack.push(cur.left);
            }
        }
    }

    private void proOrderWithRecursion(Node node) {

        if (node == null) {

            return;
        }
        System.out.println(node.e);
        proOrderWithRecursion(node.left);
        proOrderWithRecursion(node.right);
    }

    private void inOrderWithRecursion(Node node) {

        if (node == null) {

            return;
        }
        inOrderWithRecursion(node.left);
        System.out.println(node.e);
        inOrderWithRecursion(node.right);
    }

    private void postOrderWithRecursion(Node node) {

        if (node == null) {

            return;
        }
        postOrderWithRecursion(node.left);
        postOrderWithRecursion(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        generateBtsString(root, 0, res);
        return res.toString();
    }

    private void generateBtsString(Node node, int depth, StringBuilder res) {

        if (node == null) {

            res.append(generateDepthString(depth)).append("null\n");
            return;
        }
        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBtsString(node.left, depth + 1, res);
        generateBtsString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {

        StringBuilder res = new StringBuilder();
        res.append("--".repeat(Math.max(0, depth)));
        return res.toString();
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